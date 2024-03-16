package com.buildlive.companyservice.repo;

import com.buildlive.companyservice.entity.library.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRepository extends JpaRepository<Party, UUID> {
}
