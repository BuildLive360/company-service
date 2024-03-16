package com.buildlive.companyservice.entity;

import java.util.UUID;

import com.buildlive.companyservice.entity.company.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String AccountHolderName;
	
	@Column(name="Account_no:")
	private String AccountNumber;
	
	@Column(name="IFSC")
	private String IFSCCode;
	
	@Column(name="upi_id")
	private String UPIId;
	
	@Enumerated(EnumType.STRING)
	private AccountType type; 
	
	@ManyToOne()
	@JoinColumn(name="company_id")
	private Company company;

}
