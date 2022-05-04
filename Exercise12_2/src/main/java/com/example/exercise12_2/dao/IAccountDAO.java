package com.example.exercise12_2.dao;

import com.example.exercise12_2.domain.Account;

import java.util.Collection;



public interface IAccountDAO {
	public void saveAccount(Account account);
	public void updateAccount(Account account);
	public Account loadAccount(long accountnumber);
	public Collection<Account> getAccounts();
}
