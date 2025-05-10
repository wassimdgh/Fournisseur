package com.example.demo.services;

import com.example.demo.beans.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Register a new user (no encryption)
    public Utilisateur registerUser(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Find user by email (for login)
    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    // Get all users
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }

    // Update user information
    public Utilisateur updateUser(Long id, Utilisateur utilisateur) {
        if (utilisateurRepository.existsById(id)) {
            utilisateur.setId(id);
            return utilisateurRepository.save(utilisateur);
        }
        return null;  // or throw some custom exception
    }
}
