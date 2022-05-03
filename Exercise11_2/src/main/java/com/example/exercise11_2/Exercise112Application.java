package com.example.exercise11_2;

import com.example.exercise11_2.domain.Product;
import com.example.exercise11_2.service.IProductService;
import com.example.exercise11_2.service.impl.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exercise112Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new
                ClassPathXmlApplicationContext("springconfig.xml");

        IProductService productService =
                context.getBean("productService", IProductService.class);

        Product product1 = productService.getProduct(423);
        if (product1 != null) {
            System.out.println(product1.toString());
            System.out.println("Product1 Number in stock " + productService.getNumberInStock(10));
        }
        Product product2 = productService.getProduct(239);
        if (product2 != null) {
            System.out.println(product2.toString());
            System.out.println("Product2 Number in stock " + productService.getNumberInStock(20));

        }
    }

}
