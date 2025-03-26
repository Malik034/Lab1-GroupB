package com.example.lab1.services.impl;

import com.example.lab1.model.Accommodation;
import com.example.lab1.repository.AccommodationRepository;
import com.example.lab1.services.AccommodationService;
import com.example.lab1.services.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return this.accommodationRepository.findAll();
    }

    @Override
    public Accommodation findById(Long id) {
        return this.accommodationRepository.findById(id).orElse(null);
    }

    @Override
    public Accommodation save(Accommodation accommodation) {
        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation setRented(Long id) {
        Accommodation accommodation = this.findById(id);
        accommodation.setRented(!accommodation.isRented());
        return this.accommodationRepository.save(accommodation);
    }

    @Override
    public Accommodation update(Long id, Accommodation accommodation) {
        Accommodation accommodation1 = this.accommodationRepository.findById(id).orElse(null);
        if(accommodation1 == null){
            return null;
        }
        accommodation1.setName(accommodation.getName());
        accommodation1.setCategory(accommodation.getCategory());
        accommodation1.setHost(accommodation.getHost());
        accommodation1.setNumRooms(accommodation.getNumRooms());
        accommodation1.setRented((accommodation.isRented()));

        return this.accommodationRepository.save(accommodation1);
    }

    @Override
    public void deleteById(Long id) {
        Accommodation accommodation = this.findById(id);
        this.accommodationRepository.delete(accommodation);
    }
}
