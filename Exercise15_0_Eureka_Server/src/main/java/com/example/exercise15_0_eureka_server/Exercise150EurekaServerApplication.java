package com.example.exercise15_0_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Exercise150EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exercise150EurekaServerApplication.class, args);
    }

}
