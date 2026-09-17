package com.sece.eceb.service;

import com.sece.eceb.dto.Account;
import com.sece.eceb.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAccount(){
        return accountRepository.findAll();
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).get();
    }


}
