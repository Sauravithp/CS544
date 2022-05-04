package com.example.exercise13_1;

import com.example.exercise13_1.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise131Application {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "springconfig.xml");
        CustomerService customerService = context.getBean("customerServiceImpl",
                CustomerService.class);

        customerService.addCustomer("Frank Brown", "fbrown@acme.com",
                "mainstreet 5", "Chicago", "60613");

    }


}
