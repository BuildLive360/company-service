package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.WorkForce;

import java.util.List;
import java.util.UUID;

public interface WorkForceService {

    WorkForce create(WorkForceDto workForceDto);

    List<WorkForce> findByCompany(UUID id);

    void deleteWorkforce(UUID id);
}
