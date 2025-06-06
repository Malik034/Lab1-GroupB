package com.example.lab1.services.domain;

import com.example.lab1.model.domain.User;
import com.example.lab1.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface UserService extends UserDetailsService{

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

    User login(String username, String password);

    User findByUsername(String username);

}
