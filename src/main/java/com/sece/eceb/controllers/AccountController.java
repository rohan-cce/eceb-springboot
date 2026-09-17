package com.sece.eceb.controllers;


import com.sece.eceb.dto.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    // collections
    // list map, graph

    // 1) Hello World -
    // whenever you are getting data from server - mostly get
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

    ArrayList<Account> accounts = new ArrayList<>();

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account){
        //save to database
        accounts.add(account);
        return account;
    }

    @GetMapping("/account")
    public List<Account> getAccount(){
        return accounts;
    }


}






