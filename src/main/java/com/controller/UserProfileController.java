package com.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.model.Challenge;

@RestController
@Controller
public class UserProfileController {

    

    @GetMapping("/user")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Profile here");
    }

}