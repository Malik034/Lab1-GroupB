package com.example.lab1.services.application;

import com.example.lab1.dto.create.CreateHostDto;
import com.example.lab1.dto.display.DisplayHostDto;
import com.example.lab1.model.projections.HostNameProjection;
import com.example.lab1.model.views.HostsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();
    Optional<DisplayHostDto> findById(Long id);
    Optional<DisplayHostDto> save(CreateHostDto createHostDto);
    void delete(Long id);
    Optional<DisplayHostDto> update(Long id,CreateHostDto createHostDto);

    List<HostNameProjection> findHostNames();

    List<HostsPerCountryView> getHostPerCountry();
    void refreshMaterializedView();
}
