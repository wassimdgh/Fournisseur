package com.example.demo.repositories;

import com.example.demo.beans.Fournisseur;
import com.example.demo.beans.HistoriqueAchats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueAchatsRepository extends JpaRepository<HistoriqueAchats, Long> {

    // ✅ Récupérer tous les historiques pour un fournisseur donné
    List<HistoriqueAchats> findByFournisseur(Fournisseur fournisseur);
}
