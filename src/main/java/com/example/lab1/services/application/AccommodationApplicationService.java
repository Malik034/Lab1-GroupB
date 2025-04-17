package com.example.lab1.services.application;

import com.example.lab1.dto.CreateAccommodationDto;
import com.example.lab1.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto> findById(Long id);
    Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto);
    void deleteById(Long id);
    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);
    Optional<DisplayAccommodationDto>  setRented(Long id);
}