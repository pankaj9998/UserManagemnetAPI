package com.example.user.service;


import com.example.user.dto.LoginRequest;
import com.example.user.dto.UserRegisterRequest;
import com.example.user.dto.UserResponse;
import com.example.user.entity.Address;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponse register(UserRegisterRequest req) {
        var user = new User();
        user.setUsername(req.username());
        user.setPassword(passwordEncoder.encode(req.password()));
        user.setEmail(req.email());
        user.setRegistrationDate(LocalDateTime.now());

        var address = new Address();
        address.setPinCode(req.pinCode());
        address.setStreet(req.street());
        address.setCity(req.city());
        address.setState(req.state());
        user.setAddress(address);

        user = userRepository.save(user);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRegistrationDate(), address.getPinCode());
    }

    public boolean authenticate(LoginRequest req) {
        var user = userRepository.findByUsername(req.username());
        return user != null && passwordEncoder.matches(req.password(), user.getPassword());
    }

    public Page<UserResponse> search(String name, String pinCode, LocalDateTime from, LocalDateTime to, Pageable pageable) {
        var page = userRepository.search(name, pinCode, from, to, pageable);
        return page.map(u -> new UserResponse(u.getId(), u.getUsername(), u.getEmail(), u.getRegistrationDate(), u.getAddress().getPinCode()));
    }
}