package com.buildlive.companyservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkForceDto {


    private UUID companyId;
    private String workerType;
    private Long salaryPerShift;
}
