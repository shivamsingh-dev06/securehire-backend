package com.shivam.securehire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping()
    public String getAllUser(){
        return "All user Data";
    }
    @GetMapping("/profile")
    public String getProfile(){
        return "here is profile of the user";
    }
}
