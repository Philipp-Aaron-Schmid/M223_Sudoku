package com.service;

import lombok.Data;

@Data
public class TopScoreDTO {

    private int score;
    private String playerAlias;
    private String challengeTitle;

    public TopScoreDTO(int score, String playerAlias, String challengeTitle) {
        this.score = score;
        this.playerAlias = playerAlias;
        this.challengeTitle = challengeTitle;
    }
}