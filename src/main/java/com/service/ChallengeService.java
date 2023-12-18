package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Challenge;
import com.repository.ChallengeRepository;

@Service
public class ChallengeService {

    private static ChallengeRepository challengeRepository;


    @Autowired
    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;


    }

    public static void saveChallange(String challangeString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            Challenge challenge = objectMapper.readValue(challangeString, Challenge.class);
            challengeRepository.save(challenge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
