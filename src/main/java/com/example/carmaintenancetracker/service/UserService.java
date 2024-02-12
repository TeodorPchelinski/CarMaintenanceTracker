package com.example.carmaintenancetracker.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    String getUserByEmail(UserDetails currentUser);

}
