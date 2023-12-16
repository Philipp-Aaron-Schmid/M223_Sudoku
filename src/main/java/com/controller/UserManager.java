package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserManager {

    @GetMapping("/manage/users")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Manage Users here");
    }
}