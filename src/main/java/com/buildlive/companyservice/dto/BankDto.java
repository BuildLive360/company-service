package com.buildlive.companyservice.dto;

import com.buildlive.companyservice.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    private String accountHolderName;
    private String accountNumber;
    private String IFSCCode;
    private String UPIId;
    private Company company;
}
