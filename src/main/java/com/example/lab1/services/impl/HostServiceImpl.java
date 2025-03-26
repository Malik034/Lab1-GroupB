package com.example.lab1.services.impl;

import com.example.lab1.model.Host;
import com.example.lab1.repository.HostRepository;
import com.example.lab1.services.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Host findById(Long id) {
        return this.hostRepository.findById(id).orElse(null);
    }

    @Override
    public Host update(Long id, Host host) {
        Host host1 = this.hostRepository.findById(id).orElse(null);
        if(host1 == null){
            return null;
        }
        host1.setName(host.getName());
        host1.setSurname(host.getSurname());
        host1.setCountry(host.getCountry());

        return this.hostRepository.save(host1);
    }

    @Override
    public Host save(Host host) {
        return this.hostRepository.save(host);
    }

    @Override
    public void delete(Long id) {
        Host host = this.findById(id);
        this.hostRepository.delete(host);
    }
}
