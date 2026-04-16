package com.shivam.securehire.controller;

import com.shivam.securehire.model.dto.LoginRequest;
import com.shivam.securehire.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//    //simple testing
//    @GetMapping("/login")
//        public String login(){
//        return "login Api";
//        }
//        @GetMapping("/register")
//        public String register(){
//        return "register Api ";
//        }
//        @GetMapping("/{id}")
//        public String getResumeById(@PathVariable Long id){
//        return "resume with id"+ id;
//        }
//        @PostMapping
//        public String uploadResume(){
//        return "resumeUpload";
//        }
//    }

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        // simple validation (abhi basic)
        if ("shivam".equals(request.getUsername()) &&
                "1234".equals(request.getPassword())) {

            return jwtUtil.generateToken(request.getUsername());
        }

        return "Invalid credentials";
    }
}
