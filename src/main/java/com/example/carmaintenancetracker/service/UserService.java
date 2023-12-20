package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.dto.UserLoginDTO;
import com.example.carmaintenancetracker.model.dto.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    void loginUser(UserLoginDTO userLoginDTO);
}
