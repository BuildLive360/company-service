package com.buildlive.companyservice.entity.library;

import com.buildlive.companyservice.entity.company.Company;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "party",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<PartyMember> members = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
