package com.buildlive.companyservice.controller;

import com.buildlive.companyservice.dto.WorkForceDto;
import com.buildlive.companyservice.service.impl.WorkForceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

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

    @GetMapping("/{companyId}/get-workforce")
    public ResponseEntity<?> getWorkForceOfACompany(@PathVariable(name = "companyId") UUID companyId){
        return ResponseEntity.ok(workForceService.findByCompany(companyId));
    }

    @DeleteMapping("/{workerId}/delete")
    public ResponseEntity<?> deleteWorkforce(@PathVariable(name = "workerId") UUID workerId){
        try {
            workForceService.deleteWorkforce(workerId);
            return ResponseEntity.ok().build();
        }
        catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
