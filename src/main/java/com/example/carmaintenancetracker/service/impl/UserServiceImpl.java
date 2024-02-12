package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String getUserByEmail(UserDetails loggedUser) {

        //todo: Watch the lecture -> Use ResponseEntity or other way to get the String in Controller



            Optional<UserEntity> currentUser = userRepository.findByEmail(loggedUser.getUsername());

        return currentUser.get().getFirstName() + " " + currentUser.get().getLastName();
    }
}
