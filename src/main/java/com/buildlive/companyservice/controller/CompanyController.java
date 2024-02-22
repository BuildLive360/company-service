package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buildlive.companyservice.dto.CompanyDto;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;


	@PostMapping("/create")
	public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto request ){
		CompanyDto createdCompany = companyService.createCompany(request);
		return ResponseEntity.ok(createdCompany);
	}
	
}