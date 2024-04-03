package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.entity.library.WorkForce;

public interface WorkForceService {

    WorkForce create(WorkForceDto workForceDto);
}
