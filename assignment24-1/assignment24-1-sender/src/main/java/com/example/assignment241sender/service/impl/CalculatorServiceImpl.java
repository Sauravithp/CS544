package com.example.assignment241sender.service.impl;

import com.example.assignment241sender.jms.JmsSender;
import com.example.assignment241sender.domain.Calculator;
import com.example.assignment241sender.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private JmsSender jmsSender;

    @Override
    public Calculator addition(Calculator calculator){
        calculator.setResult(calculator.getFirstNumber()+ calculator.getSecondNumber());
        jmsSender.sendMessage(calculator);
        return calculator;
    }
}
