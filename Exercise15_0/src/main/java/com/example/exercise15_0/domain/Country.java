package com.example.exercise15_0.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Country {
    @Id
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String name;

    @Column(name = "last_update")
    private LocalDate modifiedDate;


}
