package com.example.exercise15_0_server.controller;

import com.example.exercise15_0_server.domain.Country;
import com.example.exercise15_0_server.feign.CountryFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryFeign countryService;

    @GetMapping("/countries")
    public List<Country> read(){
       return countryService.read();
    }



}
