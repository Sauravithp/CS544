package com.example.exercise15_0_server.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Actor {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate modifiedDate;


}
