package com.example.lab1.services.application.impl;

import com.example.lab1.dto.CreateAccommodationDto;
import com.example.lab1.dto.DisplayAccommodationDto;
import com.example.lab1.services.application.AccommodationApplicationService;
import com.example.lab1.services.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    AccommodationService accommodationService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {
        return accommodationService.save(createAccommodationDto.toAccommodation()).map(DisplayAccommodationDto::from);
    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        return accommodationService.save(createAccommodationDto.toAccommodation()).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> setRented(Long id) {
        return accommodationService.setRented(id).map(DisplayAccommodationDto::from);
    }
}