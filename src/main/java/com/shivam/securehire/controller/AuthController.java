package com.shivam.securehire.controller;

import com.shivam.securehire.model.dto.LoginRequest;
import com.shivam.securehire.model.dto.LoginResponse;
import com.shivam.securehire.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        if ("shivam".equals(request.getUsername()) &&
                "user1234".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new LoginResponse(token, request.getUsername(), "Login success");
        }

        if ("admin".equals(request.getUsername()) &&
                "admin123".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());
            return new LoginResponse(token, request.getUsername(), "Admin login success");
        }

        return new LoginResponse(null, null, "Invalid credentials");
    }
}