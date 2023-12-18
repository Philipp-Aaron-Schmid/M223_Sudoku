package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Play", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "id", "challengeId" })
})
@NoArgsConstructor
@AllArgsConstructor
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer play_id;
    //joins
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user_fk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challengeId")
    private Challenge challenge_fk;

    private String play_set;
    private int play_time;
    private boolean play_display;
    private String plays_score_set;
    private int play_score;

    public Play( User user_fk, Challenge challenge_fk) {
        this.user_fk = user_fk;
        this.challenge_fk = challenge_fk;
    }


}