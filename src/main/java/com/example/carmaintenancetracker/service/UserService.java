package com.example.carmaintenancetracker.service;

import com.example.carmaintenancetracker.model.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface UserService {
    User getUserByLogin(String login);

    UserEntity getUserByEmail();
}
