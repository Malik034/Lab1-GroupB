package com.example.lab1.services.domain;

import com.example.lab1.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> update(Long id, Country country);
    Optional<Country> save(Country country);
    void delete(Long id);

}
