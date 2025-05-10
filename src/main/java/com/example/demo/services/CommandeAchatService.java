package com.example.demo.services;

import com.example.demo.beans.CommandeAchat;
import com.example.demo.beans.HistoriqueAchats;
import com.example.demo.beans.LigneCommandeAchat;
import com.example.demo.repositories.CommandeAchatRepository;
import com.example.demo.repositories.HistoriqueAchatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeAchatService {

    @Autowired
    private CommandeAchatRepository commandeAchatRepository;

    @Autowired
    private HistoriqueAchatsRepository historiqueAchatsRepository;

    @Autowired
    private FournisseurService fournisseurService; 

    public CommandeAchat save(CommandeAchat commande) {
        // Save the commande
        CommandeAchat saved = commandeAchatRepository.save(commande);

        // Add lines to historical purchases
        for (LigneCommandeAchat ligne : saved.getLignes()) {
            HistoriqueAchats h = new HistoriqueAchats();
            h.setFournisseur(saved.getFournisseur());
            h.setProduit(ligne.getProduit());
            h.setQuantite(ligne.getQuantite());
            h.setDelaiLivraison(saved.getDelaiLivraison() != null ? saved.getDelaiLivraison() : 3); // default value if null
            historiqueAchatsRepository.save(h);
        }

        // Update the supplier's rating and quality
        fournisseurService.mettreAJourEvaluationFournisseur(saved.getFournisseur());

        return saved;
    }

    public List<CommandeAchat> findAll() {
        return commandeAchatRepository.findAll();
    }

    public CommandeAchat findById(Long id) {
        return commandeAchatRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        commandeAchatRepository.deleteById(id);
    }
}
