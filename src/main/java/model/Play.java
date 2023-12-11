package model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Plays", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "user_id", "challenge_id" })
})
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer play_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_fk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge_fk;

    private int[] play_set;
    private int play_time;
    private boolean play_display;
    private boolean[] plays_score_set;
    private int play_score;

    // Constructors,
    public Play(Integer id, User user, Challenge challenge, int[] set, int time, boolean display, boolean[] score_set, int score) {
        this.play_id = id;
        this.user_fk = user;
        this.challenge_fk = challenge;
        this.play_set = set;
        this.play_time = time;
        this.play_display = display;
        this.plays_score_set = score_set;
        this.play_score = score;
    }
        public Play(User user, Challenge challenge, int[] set, int time, boolean display, boolean[] score_set, int score) {
        this.user_fk = user;
        this.challenge_fk = challenge;
        this.play_set = set;
        this.play_time = time;
        this.play_display = display;
        this.plays_score_set = score_set;
        this.play_score = score;
    }
        public Play(User user, Challenge challenge) {
        this.user_fk = user;
        this.challenge_fk = challenge;
    }
    //getters, and setters

    public Integer getPlay_id() {
        return this.play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public User getUser_fk() {
        return this.user_fk;
    }

    public void setUser_fk(User user_fk) {
        this.user_fk = user_fk;
    }

    public Challenge getChallenge_fk() {
        return this.challenge_fk;
    }

    public void setChallenge_fk(Challenge challenge_fk) {
        this.challenge_fk = challenge_fk;
    }

    public int[] getPlay_set() {
        return this.play_set;
    }

    public void setPlay_set(int[] play_set) {
        this.play_set = play_set;
    }

    public int getPlay_time() {
        return this.play_time;
    }

    public void setPlay_time(int play_time) {
        this.play_time = play_time;
    }

    public boolean isPlay_display() {
        return this.play_display;
    }

    public boolean getPlay_display() {
        return this.play_display;
    }

    public void setPlay_display(boolean play_display) {
        this.play_display = play_display;
    }

    public boolean[] getPlays_score_set() {
        return this.plays_score_set;
    }

    public void setPlays_score_set(boolean[] plays_score_set) {
        this.plays_score_set = plays_score_set;
    }

    public int getPlay_score() {
        return this.play_score;
    }

    public void setPlay_score(int play_score) {
        this.play_score = play_score;
    }
    
}
