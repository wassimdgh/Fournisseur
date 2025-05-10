package com.example.demo.services;

import com.example.demo.beans.Fournisseur;
import com.example.demo.beans.HistoriqueAchats;
import com.example.demo.repositories.FournisseurRepository;
import com.example.demo.repositories.HistoriqueAchatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private HistoriqueAchatsRepository historiqueAchatsRepository;

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(Long id) {
        fournisseurRepository.deleteById(id);
    }

    // ✅ Évaluation dynamique sécurisée (recharge le fournisseur complet)
    public void mettreAJourEvaluationFournisseur(Fournisseur fournisseurInput) {
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurInput.getId()).orElse(null);
        if (fournisseur == null) return;

        List<HistoriqueAchats> historiques = historiqueAchatsRepository.findByFournisseur(fournisseur);

        if (historiques.isEmpty()) return;

        double moyenneDelai = historiques.stream()
                .mapToInt(HistoriqueAchats::getDelaiLivraison)
                .average()
                .orElse(0);

        double note = 5.0 - (moyenneDelai / 10.0);
        if (note < 1) note = 1;
        if (note > 5) note = 5;

        String qualite;
        if (note >= 4.5) qualite = "Excellent";
        else if (note >= 3.5) qualite = "Bon";
        else if (note >= 2.5) qualite = "Moyen";
        else qualite = "Mauvais";

        fournisseur.setNote(note);
        fournisseur.setQualiteService(qualite);

        fournisseurRepository.save(fournisseur); // ✅ mise à jour sécurisée
    }
}
