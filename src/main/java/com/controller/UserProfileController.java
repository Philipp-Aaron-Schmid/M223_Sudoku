package com.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.model.User;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserProfileController {

    private final UserRepository userRepository;
    

    public UserProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;  
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable int id) {
        // Retrieve authenticated user's username
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
    
        // Retrieve user by ID
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Check if the authenticated user matches the requested user
            if (!user.getUsername().equals(authenticatedUsername)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserProfile(@PathVariable int id, @RequestBody User updatedUser) {
        // Retrieve authenticated user's username
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        // Retrieve existing user by ID
        return userRepository.findById(id).map(existingUser -> {
            // Check if the authenticated user matches the requested user
            if (!existingUser.getUsername().equals(authenticatedUsername)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
            }

            // Update user information
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setAlias(updatedUser.getAlias());

            // Save the updated user
            userRepository.save(existingUser);

            return ResponseEntity.ok("User profile updated successfully");
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable int id) {
        // Retrieve authenticated user's username
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
    
        // Check if the user exists
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Check if the authenticated user matches the requested user
            if (!user.getUsername().equals(authenticatedUsername)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
            }
    
            // Delete the user by ID
            userRepository.deleteById(id);
            return ResponseEntity.ok("User account deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
}}
