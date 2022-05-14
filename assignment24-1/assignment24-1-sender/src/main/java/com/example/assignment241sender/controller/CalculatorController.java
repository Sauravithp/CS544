package com.example.assignment241sender.controller;

import com.example.assignment241sender.service.CalculatorService;
import com.example.assignment241sender.domain.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculators")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<?> calculators(@RequestBody Calculator calculator){
        return ResponseEntity.ok(calculatorService.addition(calculator));
    }
}
