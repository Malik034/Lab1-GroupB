package com.example.lab1.services;

import com.example.lab1.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();
    Country findById(Long id);
    Country update(Long id, Country country);
    Country save(Country country);
    void delete(Long id);

}
