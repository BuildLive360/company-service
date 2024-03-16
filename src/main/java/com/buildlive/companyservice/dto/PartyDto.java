package com.buildlive.companyservice.dto;

import com.buildlive.companyservice.entity.enums.PartyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {

    private UUID company_id;
    private String party_name;
    private String party_phone;
    private String party_email;
    private PartyType partyType;
}
