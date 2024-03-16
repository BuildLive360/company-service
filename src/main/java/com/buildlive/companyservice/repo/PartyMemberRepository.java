package com.buildlive.companyservice.repo;

import com.buildlive.companyservice.entity.library.PartyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PartyMemberRepository extends JpaRepository<PartyMember, UUID> {


}
