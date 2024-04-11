package com.buildlive.companyservice.repo;

import com.buildlive.companyservice.entity.library.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<Material, UUID> {

    List<Material> findByCompany_Id(UUID companyId);
}
