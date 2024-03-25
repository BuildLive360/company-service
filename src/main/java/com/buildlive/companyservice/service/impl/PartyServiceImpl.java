package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import com.buildlive.companyservice.dto.PartyRetrieval;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.Party;
import com.buildlive.companyservice.entity.library.PartyMember;
import com.buildlive.companyservice.repo.CompanyRepository;
import com.buildlive.companyservice.repo.PartyMemberRepository;
import com.buildlive.companyservice.repo.PartyRepository;
import com.buildlive.companyservice.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PartyServiceImpl  implements PartyService {


    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PartyMemberRepository partyMemberRepository;

    @Autowired
    PartyRepository partyRepository;
    @Override
    public void saveParties(UUID companyId) {
       Optional<Company> optionalCompany =  companyRepository.findById(companyId);
       if (optionalCompany.isPresent()){
           Company company = optionalCompany.get();
           Party party = company.getParty();

           if(party == null){
                party = new Party();
                party.setCompany(company);
           }


       }

    }

    @Override
    public ResponseEntity<PartyResponse> createParty(PartyDto partydto) {

        Optional<Company> optionalCompany =  companyRepository.findById(partydto.getCompany_id());



        if(optionalCompany.isPresent()){



                Company company = optionalCompany.get();

                if(!isPartyMemberExistsInCompany(company.getId(), partydto.getParty_email())){

                    Party party = company.getParty();
                    if(party == null){
                        party = new Party();
                        party.setCompany(company);
                        company.setParty(party);
                    }

                    PartyMember partyMember = PartyMember.builder()
                            .name(partydto.getParty_name())
                            .party_email(partydto.getParty_email())
                            .party_phone(partydto.getParty_phone())
                            .partyType(partydto.getPartyType())
                            .party(party)
                            .build();

                    party = partyRepository.save(party);
                    partyMember.setParty(party);
                    partyMemberRepository.save(partyMember);
                    return ResponseEntity.ok(PartyResponse.builder().message("Party added")
                            .status(HttpStatus.OK.value()).build());
                }
                else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PartyResponse.builder()
                            .message("Already exists").
                                    status(HttpStatus.BAD_REQUEST.value())
                                            .build());
                }



//             party.getMembers().add(partyMember);
//             partyRepository.save(party);


            }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(PartyResponse.builder().message("Check if Company exists").
                        status(HttpStatus.INTERNAL_SERVER_ERROR.value()).build());



    }




    @Override
    public  boolean checkMethod(String email,UUID id){
        return isPartyMemberExistsInCompany(id,email);
    }

    @Override
    public ResponseEntity<List<PartyRetrieval>> getAllPartyMembersOfCompany(UUID companyId) {
        System.out.println(companyId);
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        PartyRetrieval partyRetrieval = new PartyRetrieval();
        if (optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            System.out.println(company);
            Party party = company.getParty();

            if(party != null) {
                System.out.println("com 3");
                //                partyRetrieval.setPartyMembers(partyMembers);
                System.out.println(party.getMembers());
                return ResponseEntity.ok(Collections.singletonList(PartyRetrieval.builder()
                        .partyMembers(party.getMembers()).build()));
            }
            else {
               throw  new ResponseStatusException(HttpStatus.NO_CONTENT,"NO parties Found");
            }

        }
        else {
            System.out.println("No company");
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }



    private boolean isPartyMemberExistsInCompany(UUID companyId, String partyMemberEmail) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);

        if (optionalCompany.isEmpty()) {
            System.out.println("No company found with ID: " + companyId);
            return false;
        }

        Company company = optionalCompany.get();
        Party party = company.getParty();

        if (party == null) {
            System.out.println("No party found for company with ID: " + companyId);
            return false;
        }

        List<PartyMember> members = party.getMembers();

        boolean exists = members.stream()
                .anyMatch(member -> member.getParty_email().equals(partyMemberEmail));

        if (exists) {
            System.out.println("Party member with email " + partyMemberEmail + " exists in company with ID: " + companyId);
        } else {
            System.out.println("Party member with email " + partyMemberEmail + " does not exist in company with ID: " + companyId);
        }

        return exists;
    }


}
