package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/index")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Take your first steps playing sudoku");
    }
}
