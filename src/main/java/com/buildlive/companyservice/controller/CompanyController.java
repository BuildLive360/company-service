package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.dto.BankDto;
import com.buildlive.companyservice.dto.CompanyMapper;
import com.buildlive.companyservice.dto.CompanyRequest;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.service.BankAccountService;
import com.buildlive.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.buildlive.companyservice.dto.CompanyDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	CompanyService companyService;
	@Autowired
	BankAccountService bankAccountService;


	@PostMapping("/create")
	public ResponseEntity<Company> createCompany(@RequestBody Company request ){
		System.out.println(request);
		System.out.println(request.getOwner());
		Company createdCompany = companyService.createCompany(request);
		return ResponseEntity.ok(createdCompany);
	}

	@PostMapping("/saveBank")
	public ResponseEntity<BankDto> saveBankDetails(@RequestBody BankDto request){
		BankDto bankDto  = bankAccountService.saveBankDetails(request);
		return ResponseEntity.ok(bankDto);

	}

	@GetMapping("{id}")
	public ResponseEntity<CompanyDto> getCompany(@PathVariable UUID id){
		CompanyDto company = companyService.getCompanyByUser(id);
		return new ResponseEntity<>(company,HttpStatus.OK);
	}

	@PostMapping ("/findall")
	public ResponseEntity<List<CompanyDto>> getAllCompany(@RequestBody CompanyRequest userIdRequest){
		UUID userId = userIdRequest.getUserId();
		System.out.println(companyService.getAllByUser(userId));
		List<Company> companies = companyService.getAllByUser(userId);
		List<CompanyDto> dtos = companies.stream()
				.map(CompanyMapper::mapToDto)
				.collect(Collectors.toList());
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}

	@GetMapping("/find-other-companies")
	public ResponseEntity<List<CompanyDto>> findOtherCompaniesOfUser(@RequestParam(name = "userEmail") String userEmail){
		System.out.println(userEmail);
		return companyService.findOtherCompanies(userEmail);
	}



}
