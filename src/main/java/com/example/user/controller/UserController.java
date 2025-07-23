package com.example.user.controller;


import com.example.user.dto.LoginRequest;
import com.example.user.dto.UserRegisterRequest;
import com.example.user.dto.UserResponse;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean authenticated = userService.authenticate(request);
        return authenticated ? "Login successful" : "Invalid credentials";
    }

    @GetMapping("/search")
    public Page<UserResponse> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String pinCode,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = PageRequest.of(page, size);
        return userService.search(name, pinCode, from, to, pageable);
    }
}