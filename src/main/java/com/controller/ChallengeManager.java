package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.repository.ChallengeRepository;
import com.service.ChallengeService;

@Controller
public class ChallengeManager {

    private ChallengeRepository challengeRepository;

    @Autowired
    public ChallengeManager(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @GetMapping("/manage/challange")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Manage challanges here");
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

    @DeleteMapping("/manage/challange/{id}")
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
}
