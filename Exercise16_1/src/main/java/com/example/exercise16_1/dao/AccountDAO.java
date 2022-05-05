package com.example.exercise16_1.dao;

import com.example.exercise16_1.domain.Account;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;


public interface AccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public List<Account> getAccounts();
}
