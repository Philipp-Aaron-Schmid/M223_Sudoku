package com.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Challenge;
import com.repository.ChallengeRepository;
import com.service.ChallengeService;

@RestController
@RequestMapping("/manage")
public class ChallengeManager {

    private ChallengeRepository challengeRepository;
    private ChallengeService challengeService;


    public ChallengeManager(ChallengeRepository challengeRepository, ChallengeService challengeService) {
        this.challengeRepository = challengeRepository;
        this.challengeService = challengeService;
    }

    @GetMapping("/challange")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Manage challanges here");
    }

    @PostMapping("/challange/add")
    public ResponseEntity<String> addChallenge(@RequestBody String challenge) {
        try {
            ChallengeService.saveChallange(challenge);
            return ResponseEntity.status(HttpStatus.CREATED).body("Challenge added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add challenge");
        }
    }

    @DeleteMapping("/challange/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Integer id) {
        try {
            // Check if the challenge with the given ID exists
            if (challengeRepository.existsById(id)) {
                // Delete the challenge from the database
                challengeRepository.deleteById(id);
                ;
                return ResponseEntity.ok("Challenge deleted successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your use case
            return ResponseEntity.status(500).body("Error deleting challenge");
        }
    }
    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        try {
            
            List<Challenge> challenges = challengeService.getAllChallenges();

            if (!challenges.isEmpty()) {
                return ResponseEntity.ok(challenges);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
