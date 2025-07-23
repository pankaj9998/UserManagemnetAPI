package com.example.user.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public record UserRegisterRequest(
        @NotBlank String username,
        @NotBlank String password,
        @Email String email,
        @NotBlank String pinCode,
        @NotBlank String street,
        @NotBlank String city,
        @NotBlank String state
) {}