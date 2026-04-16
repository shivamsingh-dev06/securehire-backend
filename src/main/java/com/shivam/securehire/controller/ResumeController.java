package com.shivam.securehire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    @GetMapping
    public String getAllResume(){
        return "All Resume Data";
    }
    @GetMapping("/{id}")
    public String getResumeByid(@PathVariable Long id){
        return "Resume data by id";
    }
}
