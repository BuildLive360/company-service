package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.WorkForce;
import com.buildlive.companyservice.repo.CompanyRepository;
import com.buildlive.companyservice.repo.WorkForceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkForceServiceImpl implements  WorkForceService {


    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    WorkForceRepository workForceRepository;


    @Override
    public WorkForce create(WorkForceDto workForceDto) {
        Optional<Company> optionalCompany = companyRepository.findById(workForceDto.getCompanyId());

        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            WorkForce workForce = WorkForce.builder()
                    .workerType(workForceDto.getWorkerType())
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

    @Override
    public List<WorkForce> findByCompany(UUID id) {

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            return workForceRepository.findByCompany(company);
        }
        else {
            throw new RuntimeException("Not found");
        }


    }

    @Override
    public void deleteWorkforce(UUID id) {
        if(!workForceRepository.existsById(id)){
            throw new NoSuchElementException();
        }
        workForceRepository.deleteById(id);
    }


}
