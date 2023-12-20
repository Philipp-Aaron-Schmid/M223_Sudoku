package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.model.User;
import com.repository.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/manage/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserManager {

    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        // Retrieve all users
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        // Retrieve user by ID
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserProfile(@PathVariable int id, @RequestBody User updatedUser) {
        // Retrieve existing user by ID
        return userRepository.findById(id).map(existingUser -> {
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

    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdateUserProfile(@PathVariable int id, @RequestBody User partialUpdate) {
        // Retrieve existing user by ID
        return userRepository.findById(id).map(existingUser -> {
            // Update only non-null fields
            if (partialUpdate.getUsername() != null) {
                existingUser.setUsername(partialUpdate.getUsername());
            }
            if (partialUpdate.getEmail() != null) {
                existingUser.setEmail(partialUpdate.getEmail());
            }
            if (partialUpdate.getPassword() != null) {
                existingUser.setPassword(partialUpdate.getPassword());
            }
            if (partialUpdate.getAlias() != null) {
                existingUser.setAlias(partialUpdate.getAlias());
            }

            // Save the partially updated user
            userRepository.save(existingUser);

            return ResponseEntity.ok("User profile partially updated successfully");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable int id) {
        // Check if the user exists
        if (userRepository.existsById(id)) {
            // Delete the user by ID
            userRepository.deleteById(id);
            return ResponseEntity.ok("User account deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
