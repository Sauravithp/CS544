package com.example.assignment242sender.service.impl;

import com.example.assignment242sender.jms.JmsSender;
import com.example.assignment242sender.domain.Account;
import com.example.assignment242sender.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private JmsSender jmsSender;

    private static List<Account> accounts= new ArrayList<>();

    public AccountServiceImpl()
    {
        accounts.add(new Account("Sauravi",
                "Thapa",
                "Test123",
                10000D));
    }

    @Override
    public Account deposit(String accountNo, double amount){
        Account account=accounts.
                stream().
                filter(x->x.getAccountNo().equals(accountNo))
                .findFirst()
                .get();
        account.setBalance(account.getBalance()+amount);
        jmsSender.sendMessage(account);
        return account;
    }
}
