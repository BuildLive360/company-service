package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.WorkForce;
import com.buildlive.companyservice.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkForceServiceImpl implements  WorkForceService {


    @Autowired
    CompanyRepository companyRepository;


    @Override
    public WorkForce create(WorkForceDto workForceDto) {
        Optional<Company> optionalCompany = companyRepository.findById(workForceDto.getCompanyId());

        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            WorkForce workForce = WorkForce.builder()
                    .workerType(workForceDto.getPartyType())
                    .salaryPerShift(workForceDto.getSalaryPerShift())
                    .company(company)
                    .build();

            company.getWorkForces().add(workForce);
            companyRepository.save(company);
            return workForce;
        }
        else {
            throw new RuntimeException("Company Not Found");
        }
    }



}
