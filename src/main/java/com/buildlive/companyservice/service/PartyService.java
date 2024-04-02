package com.buildlive.companyservice.service;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import com.buildlive.companyservice.dto.PartyRetrieval;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.PartyMember;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PartyService {

    void saveParties(UUID companyId);

    ResponseEntity<PartyResponse> createParty(PartyDto party);

    boolean checkMethod(String email,UUID id);

   ResponseEntity<List<PartyRetrieval>> getAllPartyMembersOfCompany(UUID companyId);

   ResponseEntity<List<Company>> getOtherCompaniesOfUser(String email);




}
