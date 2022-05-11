package com.example.exercise15_0_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Exercise150ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exercise150ServerApplication.class, args);
    }

}
