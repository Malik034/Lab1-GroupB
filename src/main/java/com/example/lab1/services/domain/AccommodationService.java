package com.example.lab1.services.domain;

import com.example.lab1.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> update(Long id, Accommodation accommodation);
    Optional<Accommodation> save(Accommodation accommodation);
    Optional<Accommodation> setRented(Long id);
    void deleteById(Long id);
}
