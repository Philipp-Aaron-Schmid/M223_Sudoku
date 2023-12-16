package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Challange")
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer challangeId;

    @NotBlank
    private String challangeTitle;

    private int[] challangeSet;

    private int challangeTime;

    private boolean challangeDisplay;

    // joins
    @OneToMany(mappedBy = "challenge_fk", cascade = CascadeType.ALL)
    private Set<Play> plays = new HashSet<>();

    public Challenge( String challangeTitle, int[] challangeSet, int challangeTime, boolean challangeDisplay) {
        this.challangeTitle = challangeTitle;
        this.challangeSet = challangeSet;
        this.challangeTime = challangeTime;
        this.challangeDisplay = challangeDisplay;
    }
}