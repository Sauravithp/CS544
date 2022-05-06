package com.example.exercise17_1.dao;

import com.example.exercise17_1.domain.Account;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private SessionFactory sf;

    public void setSessionFactory(SessionFactory sf) {
        this.sf = sf;
    }

    public void saveAccount(Account account) {
        // System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());


        sf.getCurrentSession().saveOrUpdate(account);

    }

    public void updateAccount(Account account) {
        // System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            sf.getCurrentSession().merge(account);
        } else {
            saveAccount(account);
        }
    }

    public Account loadAccount(long accountnumber) {
        // System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
        List<Account> accountList = getAccounts();
        for (Account account : accountList) {
            if (account.getAccountNumber() == accountnumber) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccounts() {
        return sf.getCurrentSession().createQuery("SELECT a FROM Account a " +
                "LEFT JOIN FETCH Customer c On a.customer.id=c.id " +
                "LEFT JOIN FETCH a.entryList ").getResultList();
    }
}