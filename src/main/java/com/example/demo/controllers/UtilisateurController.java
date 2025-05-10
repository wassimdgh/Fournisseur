package com.example.demo.controllers;

import com.example.demo.beans.Utilisateur;
import com.example.demo.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Register a new user (no encryption)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUser = utilisateurService.registerUser(utilisateur);
        return ResponseEntity.ok(newUser);
    }

    // Login and return a success response (or failure)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
        Utilisateur foundUser = utilisateurService.findByEmail(utilisateur.getEmail());
        if (foundUser != null && utilisateur.getPassword().equals(foundUser.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    // Get all users (for the list)
    @GetMapping
    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAllUsers();
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        utilisateurService.deleteUser(id);
    }

    // Update user information
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur updatedUser = utilisateurService.updateUser(id, utilisateur);
        return ResponseEntity.ok(updatedUser);
    }
}
