package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChallengeManager {

    @GetMapping("/manage/challange")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Manage challanges here");
    }
}
