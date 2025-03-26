package com.example.lab1.services.impl;

import com.example.lab1.model.Country;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country update(Long id, Country country) {
        Country country1 = this.countryRepository.findById(id).orElse(null);
        if(country1 == null){
            return null;
        }
        country1.setName(country.getName());
        country1.setContinent(country.getContinent());
        return this.countryRepository.save(country1);
    }

    @Override
    public Country save(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        Country country = this.findById(id);
        this.countryRepository.delete(country);
    }
}
