package com.buildlive.companyservice.service;

import com.buildlive.companyservice.dto.MaterialDto;
import com.buildlive.companyservice.entity.library.Material;

import java.util.List;
import java.util.UUID;

public interface IMaterialService {

    void addMaterialToCompany(UUID companyId, MaterialDto request);

    List<Material> getMaterialsByCompanyId(UUID companyId);

}
