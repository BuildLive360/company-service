package com.buildlive.companyservice.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.buildlive.companyservice.entity.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findByOwner(UUID id);

    List<Company> getByOwner(UUID id);


    @Query("SELECT DISTINCT c FROM Company c JOIN c.party p JOIN p.members pm WHERE pm.party_email = :email")
    List<Company> findByPartyMemberEmail(@Param("email") String email);
}
