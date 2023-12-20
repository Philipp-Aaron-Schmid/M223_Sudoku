package com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@CrossOrigin(origins = "http://localhost:5173")
public class IndexController {

    @GetMapping("/index")
    public ResponseEntity<List<String>> getGreeting() {
        return ResponseEntity.ok(List.of("Anne Anmut", "Bernd Brot", "Chiara Clever"));
    }
}
