package com.buildlive.companyservice.service;

import org.springframework.http.ResponseEntity;

import com.buildlive.companyservice.dto.CompanyDto;


public interface CompanyService {
	
	CompanyDto createCompany(CompanyDto request);

}
