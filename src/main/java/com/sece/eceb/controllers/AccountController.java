package com.sece.eceb.controllers;


import com.sece.eceb.dto.Account;
import com.sece.eceb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    // 2 ways

    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }


    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/account")
    public List<Account> getAccount(){
        return accountService.getAccount();
    }

    @GetMapping("/account/{:id}")
    public Account getAccount(@PathVariable Long id){
        return accountService.getAccount(id);
    }


}






