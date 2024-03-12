package com.buildlive.companyservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "city_name")
	private String cityName;
	
	@Column(name="company_address")
	private String address;
	
	@Column(name="company_phone")
	private String phoneNumber;
	
	private String GSTNumber;
	private String PANNumber;
	
	@Column(name="Image")
	private String companyImage;
	
	@Column(name="owner_id")
	private UUID owner;
	
	@Enumerated(EnumType.STRING)
	private CompanyRole companyRole;

	private boolean companyIsNotPresent = true;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BankAccount> accounts = new ArrayList<>();

}
