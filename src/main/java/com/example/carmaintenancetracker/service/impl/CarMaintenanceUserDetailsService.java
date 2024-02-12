package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

// Don't put @Service it is @Bean in Configuration
public class CarMaintenanceUserDetailsService implements UserDetailsService {



    private final UserRepository userRepository;

    @Autowired
    public CarMaintenanceUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(CarMaintenanceUserDetailsService::map)
                .orElseThrow(()-> new UsernameNotFoundException("User " + email + "not found!"));
    }

    private static UserDetails map(UserEntity userEntity) {
           return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                   .authorities(List.of())    //todo: add Roles later
                .build();
    }
}
