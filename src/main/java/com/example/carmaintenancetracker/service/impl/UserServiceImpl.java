package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import com.example.carmaintenancetracker.repository.UserRepository;
import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public UserEntity getUserByEmail() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loggedUser = (UserEntity) authentication.getPrincipal();

        userRepository.findUserEntityByEmail(loggedUser.getEmail());



        return null;
    }
}
