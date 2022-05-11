package com.example.exercise15_0.controller;

import com.example.exercise15_0.domain.Country;
import com.example.exercise15_0.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> read(){
       return countryService.read();
    }

    @PutMapping("/{countryId}")
    public Country update(@RequestBody Country country,@PathVariable("countryId") Long countryId){
        return countryService.update(countryId,country);
    }

}
