package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.dto.PartyDto;
import com.buildlive.companyservice.dto.PartyResponse;
import com.buildlive.companyservice.dto.PartyRetrieval;
import com.buildlive.companyservice.service.PartyService;
import com.buildlive.companyservice.service.impl.PartyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class PartyController {

    @Autowired
    PartyServiceImpl service;
    @Autowired
    PartyService partyService;
    @PostMapping("/create-party")
    public ResponseEntity<PartyResponse> addParties(@RequestBody PartyDto party){
        System.out.println("creating coming ");
//        System.out.println(party.getPartyName());
      return   ResponseEntity.ok(partyService.createParty(party).getBody());
    }

    @PostMapping("/test")
    public ResponseEntity<Boolean> checkMethod(@RequestBody PartyDto partyDto){
        return ResponseEntity.ok(service.checkMethod(partyDto.getParty_email(),partyDto.getCompany_id()));
    }

    @GetMapping("/{company-id}/partyMembers")
    public ResponseEntity<List<PartyRetrieval>> getAllPartyMembersOfCompany(
                                  @PathVariable("company-id")UUID companyId
                                                                           )
    {
        System.out.println("1 coming");

        return partyService.getAllPartyMembersOfCompany(companyId);

    }




}
