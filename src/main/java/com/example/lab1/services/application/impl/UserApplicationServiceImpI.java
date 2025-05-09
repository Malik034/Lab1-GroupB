package com.example.lab1.services.application.impl;

import com.example.lab1.dto.create.CreateUserDto;
import com.example.lab1.dto.display.DisplayUserDto;
import com.example.lab1.dto.login.LoginUserDto;
import com.example.lab1.model.domain.User;
import com.example.lab1.services.application.UserApplicationService;
import com.example.lab1.services.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationServiceImpI implements UserApplicationService {

    UserService userService;

    public UserApplicationServiceImpI(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.confirmPassword(),
                createUserDto.name(),
                createUserDto.surname(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));

    }

    @Override
    public Optional<DisplayUserDto> login(LoginUserDto loginUserDto) {
        return Optional.of(DisplayUserDto.from(userService.login(
                loginUserDto.username(),
                loginUserDto.password()
        )));

    }

    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }
}