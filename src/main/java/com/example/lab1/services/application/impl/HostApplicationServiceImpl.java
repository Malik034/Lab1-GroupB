package com.example.lab1.services.application.impl;


import com.example.lab1.dto.CreateHostDto;
import com.example.lab1.dto.DisplayHostDto;
import com.example.lab1.services.application.HostApplicationService;
import com.example.lab1.services.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    HostService hostService;

    public HostApplicationServiceImpl(HostService hostService) {
        this.hostService = hostService;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        return hostService.save(createHostDto.toHost()).map(DisplayHostDto::from);
    }

    @Override
    public void delete(Long id) {
        hostService.delete(id);
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        return hostService.update(id, createHostDto.toHost()).map(DisplayHostDto::from);
    }
}