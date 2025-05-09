package com.example.lab1.services.application.impl;


import com.example.lab1.dto.create.CreateHostDto;
import com.example.lab1.dto.display.DisplayHostDto;
import com.example.lab1.model.projections.HostNameProjection;
import com.example.lab1.model.views.HostsPerCountryView;
import com.example.lab1.repository.HostsPerCountryViewRepository;
import com.example.lab1.services.application.HostApplicationService;
import com.example.lab1.services.domain.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    HostsPerCountryViewRepository hostsPerCountryViewRepository;
    @Autowired
    public HostApplicationServiceImpl(HostService hostService, HostsPerCountryViewRepository hostsPerCountryViewRepository) {
        this.hostService = hostService;
        this.hostsPerCountryViewRepository = hostsPerCountryViewRepository;
    }

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

    @Override
    public List<HostNameProjection> findHostNames() {
        return hostService.findHostNames();
    }
    @Override
    public List<HostsPerCountryView> getHostPerCountry() {
        return this.hostsPerCountryViewRepository.findAll();
    }

    @Override
    public void refreshMaterializedView() {
        this.hostsPerCountryViewRepository.refreshMaterializedViews();
    }
}