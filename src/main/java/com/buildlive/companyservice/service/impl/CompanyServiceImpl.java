package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.entity.enums.CompanyRole;
import com.buildlive.companyservice.repo.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.buildlive.companyservice.dto.CompanyDto;
import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.service.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {


	private final CompanyRepository companyRepository;



	@Override
	public Company createCompany(Company request) {
		Company company = Company.builder()
				.companyName(request.getCompanyName())
				.cityName(request.getCityName())
				.address(request.getAddress())
				.phoneNumber(request.getPhoneNumber())
				.GSTNumber(request.getGSTNumber())
				.PANNumber(request.getPANNumber())
				.owner(request.getOwner())
				.companyRole(CompanyRole.OWNER)
				.companyIsNotPresent(false)
				.build();
		Company savedCompany = companyRepository.save(company);
		return savedCompany;
	}

	@Override
	public CompanyDto getCompanyByUser(UUID id) {
		Optional<Company> optionalCompany = companyRepository.findByOwner(id);
		if(optionalCompany.isPresent()){
			Company company = optionalCompany.get();
			return new CompanyDto(
					company.getId(),
					company.getCompanyName(),
					company.getCityName(),
					company.getAddress(),
					company.getGSTNumber(),
					company.getPANNumber(),
					company.getPhoneNumber(),
					company.getOwner(),
					company.isCompanyIsNotPresent()
			);
		} else {
			CompanyDto companyDto = new CompanyDto();
			companyDto.setCompanyIsNotPresent(false);
			return companyDto;
		}


	}

	@Override
	public List<Company> getAllByUser(UUID id) {
		return companyRepository.getByOwner(id);
	}


	private Company mapToCompany(CompanyDto request){
		return Company.builder()
				.companyName(request.getCompanyName())
				.cityName(request.getCityName())
				.address(request.getAddress())
				.phoneNumber(request.getPhoneNumber())
				.GSTNumber(request.getGSTNumber())
				.PANNumber(request.getPANNumber())
//				.companyImage(request.getCompanyImage())
				.owner(request.getOwner())
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
//				.companyImage(company.getCompanyImage())
				.owner(company.getOwner())
//				.companyRole(company.getCompanyRole())
				.build();
	}

}
