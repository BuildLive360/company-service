package com.buildlive.companyservice.entity.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.buildlive.companyservice.entity.BankAccount;
import com.buildlive.companyservice.entity.enums.CompanyRole;
import com.buildlive.companyservice.entity.library.Material;
import com.buildlive.companyservice.entity.library.Party;
import com.buildlive.companyservice.entity.library.WorkForce;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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
	

	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true)
	@Builder.Default
	private List<BankAccount> accounts = new ArrayList<>();


	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "party_id")
	private Party party;

	@JsonManagedReference
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true)
	@Builder.Default
	private List<WorkForce> workForces = new ArrayList<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL,orphanRemoval = true)
	@Builder.Default
	List<Material> materials = new ArrayList<>();

}
