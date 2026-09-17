package com.sece.eceb.service;

import com.sece.eceb.dto.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    ArrayList<Account> accounts = new ArrayList<>();

    public Account createAccount(Account account){
        //save to database
        accounts.add(account);
        return account;
    }

    public List<Account> getAccount(){
        return accounts;
    }
}
