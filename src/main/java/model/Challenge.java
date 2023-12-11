package model;

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

@Entity
@Table(name="Challanges")
public class Challenge {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer challange_id;

 @NotBlank
 private String challange_title;
 @NotBlank
 private int[] challange_set;
 @NotBlank
 private int challange_time;
 @NotBlank
 private boolean challange_display;

 
 public Challenge(){ }
 
 public Challenge(Integer id, String title, int[] set, int time, boolean display) {
 this.challange_id = id;
 this.challange_title = title;
 this.challange_set = set;
 this.challange_time = time;
 this.challange_display = display;
 }

public Challenge(String title, int[] set, int time, boolean display) {
 this.challange_title = title;
 this.challange_set = set;
 this.challange_time = time;
 this.challange_display = display;
 }

@OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
private Set<Play> plays = new HashSet<>();

 /* all setters and getters */
 
}
