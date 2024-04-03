package com.buildlive.companyservice.entity.library;

import com.buildlive.companyservice.entity.company.Company;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkForce {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "workerType",nullable = false)
    private String workerType;

    @Column(name = "salaryPerShift",nullable = false)
    private Long salaryPerShift;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "company")
    private Company company;
}
