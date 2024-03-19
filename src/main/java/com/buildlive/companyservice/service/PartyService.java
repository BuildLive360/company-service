package com.buildlive.companyservice.service;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PartyService {

    void saveParties(UUID companyId);

    ResponseEntity<PartyResponse> createParty(PartyDto party);

    boolean checkMethod(String email,UUID id);




}
