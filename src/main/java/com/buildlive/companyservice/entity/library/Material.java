package com.buildlive.companyservice.entity.library;

import com.buildlive.companyservice.entity.company.Company;
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
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String materialName;
    private String unit;
    private Double GST;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company")
    private Company company;
}
