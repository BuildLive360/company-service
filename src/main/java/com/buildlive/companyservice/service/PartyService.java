package com.buildlive.companyservice.service;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;

import java.util.UUID;

public interface PartyService {

    void saveParties(UUID companyId);

    PartyResponse createParty(PartyDto party);


}
