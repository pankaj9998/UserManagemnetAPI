package com.example.user.dto;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String username,
        String email,
        LocalDateTime registrationDate,
        String pinCode
) {}