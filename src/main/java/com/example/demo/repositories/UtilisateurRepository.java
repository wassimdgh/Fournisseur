package com.example.demo.repositories;

import com.example.demo.beans.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    // Find user by email for login
    Utilisateur findByEmail(String email);
}
