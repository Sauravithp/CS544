package com.example.exercise16_1.dao;

import com.example.exercise16_1.domain.Account;
import com.example.exercise16_1.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
            Session session = null;
            Transaction tx = null;
            try {
                session = HibernateUtils.getSessionFactory().openSession();
                tx = session.beginTransaction();
                session.saveOrUpdate(account);
                tx.commit();
            } catch (HibernateException ex) {
                tx.rollback();
                ex.printStackTrace();
            }
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
        Session session = null;
        Transaction tx = null;
        List<Account> accountList = new ArrayList<>();
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            accountList = session.createQuery("SELECT a FROM Account a").list();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        return accountList;
    }

}
