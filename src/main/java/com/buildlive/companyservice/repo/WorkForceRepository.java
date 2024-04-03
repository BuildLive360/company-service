package com.buildlive.companyservice.repo;

import com.buildlive.companyservice.entity.company.Company;
import com.buildlive.companyservice.entity.library.WorkForce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkForceRepository extends JpaRepository<WorkForce, UUID> {

    List<WorkForce> findByCompany(Company company);
}
