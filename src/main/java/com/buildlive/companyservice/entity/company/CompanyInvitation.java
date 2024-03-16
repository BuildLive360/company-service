package com.buildlive.companyservice.entity.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInvitation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID sender;
    private UUID receiver;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private LocalDateTime sendDateTime;

    @Enumerated(EnumType.STRING)
    private InvitationStatus status;
}
