package com.example.carmaintenancetracker.service;

import org.springframework.security.core.userdetails.User;

public interface UserService {
    User getUserByLogin(String login);
}
