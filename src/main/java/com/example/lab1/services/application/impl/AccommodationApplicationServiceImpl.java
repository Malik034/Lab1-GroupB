package com.example.lab1.services.application.impl;

import com.example.lab1.dto.create.CreateAccommodationDto;
import com.example.lab1.dto.display.DisplayAccommodationDto;
import com.example.lab1.model.views.AccommodationsPerHostView;
import com.example.lab1.repository.AccommodationsPerHostViewRepository;
import com.example.lab1.services.application.AccommodationApplicationService;
import com.example.lab1.services.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    AccommodationService accommodationService;
    AccommodationsPerHostViewRepository accommodationsPerHostViewRepository;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, AccommodationsPerHostViewRepository accommodationsPerHostViewRepository) {
        this.accommodationService = accommodationService;
        this.accommodationsPerHostViewRepository = accommodationsPerHostViewRepository;
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

    @Override
    public List<AccommodationsPerHostView> getAccommodationsPerHost() {
        return this.accommodationsPerHostViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        accommodationsPerHostViewRepository.refreshMaterializedViews();
    }
}