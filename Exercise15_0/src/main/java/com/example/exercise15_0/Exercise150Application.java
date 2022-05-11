package com.example.exercise15_0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Exercise150Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise150Application.class, args);
    }

}
