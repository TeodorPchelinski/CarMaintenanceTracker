package com.example.carmaintenancetracker.model.dto;

public record UserRegistrationDTO(String firstName, String lastName, String username, String email,String password, String confirmPassword) {
}
