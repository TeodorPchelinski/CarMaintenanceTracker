package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class CarMaintenanceUserDetailsService implements UserDetailsService {


    private UserRepository userRepository;

    public CarMaintenanceUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::map)
                .orElseThrow(()-> new UsernameNotFoundException("User " + email + "not found!"));

    }

    private UserDetails map(UserEntity userEntity) {
           return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                    .authorities(List.of())//todo: add Roles later
                .build();


    }
}
