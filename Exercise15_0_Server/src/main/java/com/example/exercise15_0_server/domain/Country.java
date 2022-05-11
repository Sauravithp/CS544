package com.example.exercise15_0_server.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Country {

    private Long id;

    private String name;

    private LocalDate modifiedDate;
}
