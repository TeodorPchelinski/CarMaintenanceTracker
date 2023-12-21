package com.example.carmaintenancetracker.service.impl;

import com.example.carmaintenancetracker.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByLogin(String login) {
        return null;
    }
}
