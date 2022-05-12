package com.example.exercise15_0_server.controller;

import com.example.exercise15_0_server.domain.Country;
import com.example.exercise15_0_server.feign.CountryFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryFeign countryService;

    @GetMapping("/countries")
    @HystrixCommand(fallbackMethod = "readFallBack")
    public List<Country> read(){
       return countryService.read();
    }

    public List<Country> readFallBack(){
        return Arrays.asList(new Country());
    }

}
