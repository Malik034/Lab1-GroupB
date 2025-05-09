package com.example.lab1.dto.create;

import com.example.lab1.model.domain.Country;
import com.example.lab1.model.domain.Host;

public record CreateHostDto(String name, String surname, Country country) {

    public Host toHost() {
        return new Host(name, surname, country);
    }
}