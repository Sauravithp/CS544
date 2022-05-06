package com.example.exercise15_1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise151Application {

    public static void main(String[] args) {
        @SuppressWarnings({ "unused", "resource" })
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
        BillingService billingService=context.getBean("billingServiceImpl",BillingService.class);
//        billingService.generateBillingReport();
//        billingService.printBills();
    }

}
