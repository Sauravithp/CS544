package com.example.exercise17_1.dao;

import com.example.exercise17_1.domain.Account;
import com.example.exercise17_1.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    public void saveAccount(Account account) {
        // System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());


        HibernateUtils.getSessionFactory().getCurrentSession().saveOrUpdate(account);

    }

    public void updateAccount(Account account) {
        // System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            HibernateUtils.getSessionFactory().getCurrentSession().merge(account);
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
        return HibernateUtils.getSessionFactory().getCurrentSession().createQuery("SELECT a FROM Account a " +
                "LEFT JOIN FETCH Customer c On a.customer.id=c.id " +
                "LEFT JOIN FETCH a.entryList ").getResultList();
    }

}
