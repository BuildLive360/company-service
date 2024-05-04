package com.buildlive.companyservice.service;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import com.buildlive.companyservice.dto.PartyRetrieval;
import com.buildlive.companyservice.entity.company.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PartyService {

    void saveParties(UUID companyId);

    ResponseEntity<PartyResponse> createParty(PartyDto party);

    boolean checkMethod(String email,UUID id);

   ResponseEntity<List<PartyRetrieval>> getAllPartyMembersOfCompany(UUID companyId);

   ResponseEntity<List<Company>> getOtherCompaniesOfUser(String email);

   String getPartyMemberName(String email,UUID companyId);

   UUID getPartyMemberId(String email, UUID companyId);




}
