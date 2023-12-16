package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.repository.ChallengeRepository;
import com.service.ChallengeService;



@RestController
@RequestMapping("/challenges")
public class ChallengeController {
        private final ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeController(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @PostMapping("manage/challange/add")
    public ResponseEntity<String> addChallenge(@RequestBody String challenge) {
        try {
            ChallengeService.saveChallange(challenge);
            return ResponseEntity.status(HttpStatus.CREATED).body("Challenge added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add challenge");
        }
    }


    @GetMapping("/manage/challange")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("challanges here");
    }

}