package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayController {

    @GetMapping("/play")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("let'splay a game!");
    }
}