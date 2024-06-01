package com.example.carmaintenancetracker.model.dto;

import com.example.carmaintenancetracker.model.validation.FieldMatch;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Password should match"
)

public record UserRegistrationDTO(String firstName, String lastName, String email, String password, String confirmPassword) {


}
