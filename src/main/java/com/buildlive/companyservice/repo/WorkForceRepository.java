package com.buildlive.companyservice.repo;

import com.buildlive.companyservice.entity.library.WorkForce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkForceRepository extends JpaRepository<WorkForce, UUID> {
}
