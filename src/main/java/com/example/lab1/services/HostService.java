package com.example.lab1.services;

import com.example.lab1.model.Host;

import java.util.List;

public interface HostService {
    List<Host> findAll();
    Host findById(Long id);
    Host update(Long id, Host host);
    Host save(Host host);
    void delete(Long id);
}
