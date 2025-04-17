package com.example.lab1.dto;

import com.example.lab1.model.domain.User;
import com.example.lab1.model.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String confirmPassword,
        String name,
        String surname,
        Role role) {

    public User toUser() {
        return new User(username,password,name,surname,role);
    }
}