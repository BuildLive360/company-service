package com.buildlive.companyservice.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buildlive.companyservice.entity.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findByOwner(UUID id);

    List<Company> getByOwner(UUID id);
}
