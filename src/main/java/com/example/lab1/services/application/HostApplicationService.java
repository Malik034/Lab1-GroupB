package com.example.lab1.services.application;

import com.example.lab1.dto.CreateHostDto;
import com.example.lab1.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> findById(Long id);
    Optional<DisplayHostDto> save(CreateHostDto createHostDto);
    void delete(Long id);
    Optional<DisplayHostDto> update(Long id,CreateHostDto createHostDto);
}
