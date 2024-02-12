package com.example.carmaintenancetracker.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User getUserByLogin(String login);

    String getUserByEmail(UserDetails currentUser);

}
