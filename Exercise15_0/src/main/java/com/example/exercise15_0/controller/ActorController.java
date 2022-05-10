package com.example.exercise15_0.controller;

import com.example.exercise15_0.domain.Actor;
import com.example.exercise15_0.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService addressService;

    @GetMapping
    public List<Actor> read(){
        return addressService.read();
    }
}
