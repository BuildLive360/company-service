package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.MaterialDto;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.Material;
import com.buildlive.companyservice.repo.CompanyRepository;
import com.buildlive.companyservice.repo.MaterialRepository;
import com.buildlive.companyservice.service.IMaterialService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public void addMaterialToCompany(UUID companyId, MaterialDto request) {

        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();

           Material material = Material.builder()
                   .materialName(request.getName())
                   .unit(request.getUnit())
                   .GST(request.getGst())
                   .company(company)
                   .build();

           company.getMaterials().add(material);
           companyRepository.save(company);
        }
        else {
            throw new IllegalArgumentException("Company Not Found");
        }

    }

    @Override
    public List<Material> getMaterialsByCompanyId(UUID companyId) {
        return materialRepository.findByCompany_Id(companyId);
    }
}
