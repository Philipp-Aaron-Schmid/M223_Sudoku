package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScoreController {

    @GetMapping("/score")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Display of high Scores");
    }
}