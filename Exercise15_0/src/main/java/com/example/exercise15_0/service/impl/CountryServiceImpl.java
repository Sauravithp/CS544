package com.example.exercise15_0.service.impl;

import com.example.exercise15_0.dao.CountryRepository;
import com.example.exercise15_0.domain.Country;
import com.example.exercise15_0.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> read() {
        return countryRepository.findAll();
    }
}
