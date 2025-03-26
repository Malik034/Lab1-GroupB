package com.example.lab1.services;

import com.example.lab1.model.Accommodation;

import java.util.List;

public interface AccommodationService {

    List<Accommodation> findAll();
    Accommodation findById(Long id);
    Accommodation update(Long id, Accommodation accommodation);
    Accommodation save(Accommodation accommodation);
    Accommodation setRented(Long id);
    void deleteById(Long id);
}
