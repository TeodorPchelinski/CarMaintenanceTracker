package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.UserRegistrationDTO;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String getUserByEmail(UserDetails loggedUser) {

        //todo: Watch the lecture -> Use ResponseEntity or other way to get the String in Controller

        Optional<UserEntity> currentUser = userRepository.findByEmail(loggedUser.getUsername());

        return currentUser.get().getFirstName() + " " + currentUser.get().getLastName();
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){
        return new UserEntity()
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

    }


}
