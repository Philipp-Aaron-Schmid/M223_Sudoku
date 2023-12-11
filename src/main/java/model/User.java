package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer user_id;
 
 @NotBlank
 private String user_name;
 @NotBlank
 private String user_email;
 @NotBlank
 private String user_password;
 @NotBlank
 private String user_alias;
 @NotBlank
 @Enumerated(EnumType.STRING)
 private  Role user_role;
 
 public User(){ }
 
 public User(Integer id, String name, String email, String alias, String password) {
 this.user_id = id;
 this.user_name = name;
 this.user_email = email;
 this.user_alias = alias;
 this.user_password = password;

 }
 public User(String name, String email, String alias, String password) {
 this.user_name = name;
 this.user_email = email;
 this.user_alias = alias;
 this.user_password = password;
 }
 
     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Play> plays = new HashSet<>();
 /* all setters and getters */
 
}

enum Role {
    USER,
    ADMIN
}
