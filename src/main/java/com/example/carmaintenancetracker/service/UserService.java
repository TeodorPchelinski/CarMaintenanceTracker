package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    String getUserByEmail(UserDetails currentUser);

    void registerUser(UserRegistrationDTO userRegistrationDTO);

}
