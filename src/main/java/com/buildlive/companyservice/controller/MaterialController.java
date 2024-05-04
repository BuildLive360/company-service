package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.dto.CompanyDto;
import com.buildlive.companyservice.dto.MaterialDto;
import com.buildlive.companyservice.entity.library.Material;
import com.buildlive.companyservice.service.IMaterialService;
import com.buildlive.companyservice.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class MaterialController {

    @Autowired
    IMaterialService materialService;

    @Autowired
    PartyService partyService;

    @PostMapping("{companyId}/add-material")
    public ResponseEntity<?> addMaterialToCompany(@PathVariable UUID companyId,
                                                  @RequestBody MaterialDto materialDto){

        try {
            materialService.addMaterialToCompany(companyId,materialDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{companyId}/get-company-materials")
    public ResponseEntity<List<Material>> getAllMaterialsOfACompany(@PathVariable(name = "companyId") UUID companyId){
        return ResponseEntity.ok(materialService.getMaterialsByCompanyId(companyId));
    }

    @GetMapping("{companyId}/get-partyMember-name/{email}")
    public String getPartyMemberName(@PathVariable String email, @PathVariable UUID companyId){
        return partyService.getPartyMemberName(email,companyId);
    }





}
