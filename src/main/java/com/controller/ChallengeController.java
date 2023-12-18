package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Challenge;
import com.repository.ChallengeRepository;
import com.repository.PlayRepository;
import com.service.ChallengeService;

import lombok.Data;



@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private final ChallengeRepository challengeRepository;
    private PlayRepository playRepository;

    @Autowired
    public ChallengeController(ChallengeRepository challengeRepository, PlayRepository playRepository) {
        this.challengeRepository = challengeRepository;
        this.playRepository = playRepository;
    }

    @GetMapping("/manage/challange")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("challanges here");
    }

    /*@GetMapping("/challanges/{userId}")
    public Set<Challenge> getChallengesExcludePlayed(@PathVariable Integer userId) {
        // Assuming Play entity has userId and challengeId fields
        Set<Integer> playedChallengeIds = playRepository.findPlayedChallengeIdsById(userId);

        return ;


    }*/
     @GetMapping("challenges/all")
    public ResponseEntity<Set<ChallengeResponseDTO>> getAllChallenges() {
        Set<ChallengeResponseDTO> challenges = challengeRepository.findByChallangeDisplayTrue()
                .stream()
                .map(challenge -> new ChallengeResponseDTO(
                        challenge.getChallangeId(),
                        challenge.getChallangeTitle(),
                        challenge.getChallangeTime()
                ))
                .collect(Collectors.toSet());

        return ResponseEntity.ok(challenges);
    }
}
@Data
class ChallengeResponseDTO {

    private Integer challangeId;
    private String challangeTitle;
    private int challangeTime;


    public ChallengeResponseDTO(Integer challangeId, String challangeTitle, int challangeTime) {
        this.challangeId = challangeId;
        this.challangeTitle = challangeTitle;
        this.challangeTime = challangeTime;
    }

}