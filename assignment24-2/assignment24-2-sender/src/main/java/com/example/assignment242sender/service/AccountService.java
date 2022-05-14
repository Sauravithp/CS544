package com.example.assignment242sender.service;

import com.example.assignment242sender.domain.Account;

public interface AccountService {
     Account deposit(String accountNo, double amount);
}
