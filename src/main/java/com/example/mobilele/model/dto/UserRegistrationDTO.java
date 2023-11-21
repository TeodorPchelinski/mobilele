package com.example.mobilele.model.dto;

import com.example.mobilele.model.validation.FieldMatch;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match"
)
public record UserRegistrationDTO(String firstName, String lastName, String username, String email, String password, String confirmPassword) {
}
