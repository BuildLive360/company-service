package com.buildlive.companyservice.entity.library;

import com.buildlive.companyservice.entity.enums.CompanyRole;
import com.buildlive.companyservice.entity.enums.PartyType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String party_email;
    private String party_phone;

    @Enumerated(EnumType.STRING)
    private PartyType partyType;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "party_id")
    private Party party;

    @Enumerated(EnumType.STRING)
    private CompanyRole companyRole;






}
