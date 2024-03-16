package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.Party;
import com.buildlive.companyservice.entity.library.PartyMember;
import com.buildlive.companyservice.repo.CompanyRepository;
import com.buildlive.companyservice.repo.PartyMemberRepository;
import com.buildlive.companyservice.repo.PartyRepository;
import com.buildlive.companyservice.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PartyResponse createParty(PartyDto partydto) {

        Optional<Company> optionalCompany =  companyRepository.findById(partydto.getCompany_id());
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();

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


//             party.getMembers().add(partyMember);
//             partyRepository.save(party);

            return PartyResponse.builder()
                    .message("Created party").build();



        }
        else {
            return PartyResponse.builder().message("Failed")
                    .build();
        }

    }


}
