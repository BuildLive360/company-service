package com.buildlive.companyservice.service.impl;

import com.buildlive.companyservice.dto.BankDto;
import com.buildlive.companyservice.entity.AccountType;
import com.buildlive.companyservice.entity.BankAccount;
import com.buildlive.companyservice.entity.Company;
import com.buildlive.companyservice.repo.BankAccountRepository;
import com.buildlive.companyservice.repo.CompanyRepository;
import com.buildlive.companyservice.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final CompanyRepository companyRepository;


    @Override
    public BankDto saveBankDetails(BankDto request) {

       Company company =  request.getCompany();
       UUID id =  company.getId();
       Optional<Company> company1 = companyRepository.findById(id);
       if(company1.isPresent()){
           Company existingCompany = company1.get();
           if(existingCompany.getAccounts() == null || existingCompany.getAccounts().isEmpty()){
               BankAccount primaryAccount = mapToBankAccount(request);
               primaryAccount.setType(AccountType.PRIMARY_ACCOUNT);
               List<BankAccount> accounts = new ArrayList<>();
               accounts.add(primaryAccount);
               existingCompany.setAccounts(accounts);


           }
           else {
               BankAccount secondaryAccount = mapToBankAccount(request);
               secondaryAccount.setType(AccountType.SECONDARY_ACCOUNT);
               existingCompany.getAccounts().add(secondaryAccount);
           }
           companyRepository.save(existingCompany);
       }

        return BankDto.builder().build();
    }

    private BankAccount mapToBankAccount(BankDto bankDto){
        return BankAccount.builder().
                AccountHolderName(bankDto.getAccountHolderName())
                .AccountNumber(bankDto.getAccountNumber())
                .IFSCCode(bankDto.getIFSCCode())
                .UPIId(bankDto.getUPIId())
                .company(bankDto.getCompany())
                .build();
    }
}
