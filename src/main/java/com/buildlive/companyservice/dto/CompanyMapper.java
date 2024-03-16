package com.buildlive.companyservice.dto;

import com.buildlive.companyservice.entity.company.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public static  CompanyDto mapToDto(Company company){
        CompanyDto dto = CompanyDto.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .cityName(company.getCityName())
                .address(company.getAddress())
                .phoneNumber(company.getPhoneNumber())
                .GSTNumber(company.getGSTNumber())
                .PANNumber(company.getPANNumber())
//				.companyImage(company.getCompanyImage())
                .owner(company.getOwner())
//				.companyRole(company.getCompanyRole())
                .build();

        return dto;
    }
}
