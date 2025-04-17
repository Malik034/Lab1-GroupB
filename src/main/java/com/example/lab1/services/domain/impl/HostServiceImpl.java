package com.example.lab1.services.domain.impl;

import com.example.lab1.model.domain.Host;
import com.example.lab1.repository.HostRepository;
import com.example.lab1.services.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return this.hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return this.hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingHost -> {
            if (host.getName() != null) {
                existingHost.setName(host.getName());
            }
            if (host.getSurname() != null) {
                existingHost.setSurname(host.getSurname());
            }
            if (host.getCountry() != null) {
                existingHost.setCountry(host.getCountry());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public Optional<Host> save(Host host) {
        return Optional.of(this.hostRepository.save(host));
    }

    @Override
    public void delete(Long id) {
        this.hostRepository.deleteById(id);
    }
}
