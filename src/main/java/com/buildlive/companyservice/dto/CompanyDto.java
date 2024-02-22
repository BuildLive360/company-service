package com.buildlive.companyservice.dto;


import java.util.UUID;

import com.buildlive.companyservice.entity.CompanyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	
		private String companyName;
		private String cityName;
		private String address;
		private String phoneNumber;
		private String GSTNumber;
		private String PANNumber;
		private String companyImage;		
		private UUID user;
		private CompanyRole companyRole;




}
