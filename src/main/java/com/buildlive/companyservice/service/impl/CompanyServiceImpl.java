package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.entity.CompanyRole;
import com.buildlive.companyservice.repo.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.buildlive.companyservice.dto.CompanyDto;
import com.buildlive.companyservice.entity.Company;
import com.buildlive.companyservice.service.CompanyService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {


	private final CompanyRepository companyRepository;

	@Override
	public CompanyDto createCompany(CompanyDto request) {
		Company company = mapToCompany(request);
		Company savedCompany = companyRepository.save(company);
		return mapToCompanyDto(savedCompany);
	}


	private Company mapToCompany(CompanyDto request){
		return Company.builder()
				.companyName(request.getCompanyName())
				.cityName(request.getCityName())
				.address(request.getAddress())
				.phoneNumber(request.getPhoneNumber())
				.GSTNumber(request.getGSTNumber())
				.PANNumber(request.getPANNumber())
				.companyImage(request.getCompanyImage())
				.owner(request.getUser())
				.companyRole(CompanyRole.OWNER)
				.build();
	}

	private CompanyDto mapToCompanyDto(Company company){
		return CompanyDto.builder()
				.companyName(company.getCompanyName())
				.cityName(company.getCityName())
				.address(company.getAddress())
				.phoneNumber(company.getPhoneNumber())
				.GSTNumber(company.getGSTNumber())
				.PANNumber(company.getPANNumber())
				.companyImage(company.getCompanyImage())
				.user(company.getOwner())
				.companyRole(company.getCompanyRole())
				.build();
	}

}
