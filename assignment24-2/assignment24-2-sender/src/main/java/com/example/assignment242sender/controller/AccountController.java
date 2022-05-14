package com.example.assignment242sender.controller;

import com.example.assignment242sender.service.AccountService;
import com.example.assignment242sender.service.impl.AccountServiceImpl;
import com.example.assignment242sender.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PutMapping("/deposit/{accountNo}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable String accountNo, @PathVariable Double amount){
        return ResponseEntity.ok(accountService.deposit(accountNo,amount));
    }
}
