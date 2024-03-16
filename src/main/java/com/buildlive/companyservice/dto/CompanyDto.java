package com.buildlive.companyservice.dto;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
		private UUID id;
		private String companyName;
		private String cityName;
		private String address;
		private String phoneNumber;
		private String GSTNumber;
		private String PANNumber;
		private UUID owner;
		private boolean companyIsNotPresent;







}
