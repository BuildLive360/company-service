package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.service.impl.WorkForceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class WorkForceController {

    @Autowired
    private WorkForceService workForceService;

    @PostMapping("/workforce/create")
    public ResponseEntity<?> createWorkforce(@RequestBody WorkForceDto workForceDto){
        System.out.println(workForceDto.getCompanyId());
        try {
            return ResponseEntity.ok(workForceService.create(workForceDto));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
        }

    }
}
