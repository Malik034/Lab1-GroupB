package com.example.lab1.services.application.impl;

import com.example.lab1.dto.create.CreateCountryDto;
import com.example.lab1.dto.display.DisplayCountryDto;
import com.example.lab1.repository.HostsPerCountryViewRepository;
import com.example.lab1.services.application.CountryApplicationService;
import com.example.lab1.services.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    CountryService countryService;
    HostsPerCountryViewRepository hostsPerCountryViewRepository;

    public CountryApplicationServiceImpl(CountryService countryService, HostsPerCountryViewRepository hostsPerCountryViewRepository) {
        this.countryService = countryService;
        this.hostsPerCountryViewRepository = hostsPerCountryViewRepository;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto) {
        return countryService.save(createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.update(id, createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryService.delete(id);
    }

    @Override
    public void refreshMaterializedView() {
        this.hostsPerCountryViewRepository.refreshMaterializedViews();
    }
}