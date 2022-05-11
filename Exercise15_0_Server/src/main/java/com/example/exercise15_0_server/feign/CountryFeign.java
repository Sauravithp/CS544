package com.example.exercise15_0_server.feign;

import com.example.exercise15_0_server.domain.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name ="exercise15" ,url = "http://localhost:8080")
public interface CountryFeign {

    @GetMapping("/countries")
    List<Country> read();
}
