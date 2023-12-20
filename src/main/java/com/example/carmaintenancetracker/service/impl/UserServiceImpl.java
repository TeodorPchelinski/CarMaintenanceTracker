package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.dto.UserRegistrationDTO;
import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        if (userRegistrationDTO.getPassword() == null){
            System.out.println(userRegistrationDTO.getPassword());
        }else {

            return new UserEntity()
                    .setFirstName(userRegistrationDTO.getFirstName())
                    .setLastName(userRegistrationDTO.getLastName())
                    .setEmail(userRegistrationDTO.getEmail())
                    .setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        }

        return null;
    }
}
