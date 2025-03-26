package com.example.lab1.data;

import com.example.lab1.model.Accommodation;
import com.example.lab1.model.Country;
import com.example.lab1.model.Host;
import com.example.lab1.model.enumerations.AccommodationCategory;
import com.example.lab1.repository.AccommodationRepository;
import com.example.lab1.repository.CountryRepository;
import com.example.lab1.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {

        Country northMacedonia = countryRepository.save(new Country("North Macedonia", "Europe"));
        Country belgium = countryRepository.save(new Country("Belgium", "Europe"));
        Country china = countryRepository.save(new Country("China", "Asia"));

        Host host1 = hostRepository.save(new Host("John", "Smith", northMacedonia));
        Host host2 = hostRepository.save(new Host("Josh", "Eve", belgium));
        Host host3 = hostRepository.save(new Host("Alice", "Wang", china));

        accommodationRepository.save(new Accommodation("Skopje Hotel", AccommodationCategory.HOTEL, host1, 100, true));
        accommodationRepository.save(new Accommodation("Brussels Apartment", AccommodationCategory.APARTMENT, host2, 4, false));
        accommodationRepository.save(new Accommodation("Beijing Motel", AccommodationCategory.MOTEL, host3, 30, true));
    }
}
