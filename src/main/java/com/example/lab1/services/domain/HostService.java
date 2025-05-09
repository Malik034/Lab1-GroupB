package com.example.lab1.services.domain;

import com.example.lab1.model.domain.Host;
import com.example.lab1.model.projections.HostNameProjection;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);
    Optional<Host> update(Long id, Host host);
    Optional<Host> save(Host host);
    void delete(Long id);

    List<HostNameProjection> findHostNames();
}
