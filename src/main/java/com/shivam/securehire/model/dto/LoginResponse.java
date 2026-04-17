package com.shivam.securehire.model.dto;

public class LoginResponse {

    private String token;
    private String username;
    private String message;

    // Constructor
    public LoginResponse(String token, String username, String message) {
        this.token = token;
        this.username = username;
        this.message = message;
    }

    // Getters
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }
}