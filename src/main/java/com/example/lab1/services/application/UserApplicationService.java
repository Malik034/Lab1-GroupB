package com.example.lab1.services.application;

import com.example.lab1.dto.create.CreateUserDto;
import com.example.lab1.dto.display.DisplayUserDto;
import com.example.lab1.dto.login.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<DisplayUserDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}
