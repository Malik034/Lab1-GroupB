package com.example.lab1.services.application;

import com.example.lab1.dto.CreateCountryDto;
import com.example.lab1.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto);
    Optional<DisplayCountryDto> update(Long id,CreateCountryDto createCountryDto);
    void delete(Long id);

}
