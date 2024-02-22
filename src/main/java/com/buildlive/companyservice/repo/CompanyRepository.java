package com.buildlive.companyservice.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildlive.companyservice.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
