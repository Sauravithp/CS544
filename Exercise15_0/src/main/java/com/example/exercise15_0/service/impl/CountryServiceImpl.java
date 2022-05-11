package com.example.exercise15_0.service.impl;

import com.example.exercise15_0.dao.CountryRepository;
import com.example.exercise15_0.domain.Country;
import com.example.exercise15_0.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> read() {
        return countryRepository.findAll();
    }

    @Override
    public Country update(Long countryId, Country country) {
        try{
            Country storedData=countryRepository.getById(countryId);
            storedData.setName(country.getName());
            storedData.setModifiedDate(LocalDate.now());
            return countryRepository.save(storedData);
        }catch (Exception e){
            return countryRepository.save(country);
        }
    }
}
