package com.shivam.securehire.controller;
import org.springframework.security.core.Authentication;
import com.shivam.securehire.model.dto.LoginRequest;
import com.shivam.securehire.model.dto.LoginResponse;
import com.shivam.securehire.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            String username = authentication.getName();

            String token = jwtUtil.generateToken(username);

            return new LoginResponse(token, username, "Login success");

        } catch (Exception e) {
            return new LoginResponse(null, null, "Invalid credentials");
        }
    }
}