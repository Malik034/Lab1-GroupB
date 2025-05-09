package com.example.lab1.dto.create;

import com.example.lab1.model.domain.Accommodation;
import com.example.lab1.model.domain.Host;
import com.example.lab1.model.enumerations.AccommodationCategory;

public record CreateAccommodationDto(String name, AccommodationCategory category, Host host, int numRooms, boolean active) {

    public Accommodation toAccommodation() {
        return new Accommodation(name, category, host, numRooms, active);
    }

}