package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Take your first steps playing sudoku");
    }
}
