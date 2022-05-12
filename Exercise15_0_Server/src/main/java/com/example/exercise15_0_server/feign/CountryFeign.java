package com.example.exercise15_0_server.feign;

import com.example.exercise15_0_server.configuration.FeignClientConfiguration;
import com.example.exercise15_0_server.domain.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="country-service",configuration = FeignClientConfiguration.class)
public interface CountryFeign {

    @GetMapping("/countries")
    List<Country> read();

}


//