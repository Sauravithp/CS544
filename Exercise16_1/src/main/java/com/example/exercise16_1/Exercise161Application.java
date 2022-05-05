package com.example.exercise16_1;


import com.example.exercise16_1.domain.Account;
import com.example.exercise16_1.domain.AccountEntry;
import com.example.exercise16_1.domain.Customer;
import com.example.exercise16_1.service.AccountService;
import com.example.exercise16_1.service.AccountServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

public class Exercise161Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("springConfig.xml");
        AccountService accountService = context.getBean("accountServiceImpl",AccountService.class);
        // create 2 accounts;
        try{
            accountService.createAccount(1263862, "Frank Brown");
            accountService.createAccount(4253892, "John Doe");
            // use account 1;
            accountService.deposit(1263862, 240);
            accountService.deposit(1263862, 529);
            accountService.withdrawEuros(1263862, 230);
            // use account 2;
            accountService.deposit(4253892, 12450);
            accountService.depositEuros(4253892, 200);
            accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
            // show balances

            Collection<Account> accountlist = accountService.getAllAccounts();
            Customer customer = null;
            for (Account account : accountlist) {
                customer = account.getCustomer();
                System.out.println("Statement for Account: " + account.getAccountNumber());
                System.out.println("Account Holder: " + customer.getName());
                System.out.println(
                        "-Date-------------------------" + "-Description------------------" + "-Amount-------------");
                if(!account.getEntryList().isEmpty()) {
                    for (AccountEntry entry : account.getEntryList()) {
                        System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
                                entry.getAmount());
                    }
                }
                System.out.println("----------------------------------------" + "----------------------------------------");
                System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
            }
        }catch (Exception e){
            System.out.println("Error--------------->"+e.getMessage());
        }

    }


}
