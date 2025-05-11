package com.example.demo.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CommandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String statut;
    private Double montant;
    private Integer delaiLivraison;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    @JsonIgnoreProperties("commandes") // au lieu de @JsonBackReference
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<LigneCommandeAchat> lignes;

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }

    public Integer getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(Integer delaiLivraison) { this.delaiLivraison = delaiLivraison; }

    public Fournisseur getFournisseur() { return fournisseur; }
    public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }

    public List<LigneCommandeAchat> getLignes() { return lignes; }
    public void setLignes(List<LigneCommandeAchat> lignes) {
        this.lignes = lignes;
        if (lignes != null) {
            for (LigneCommandeAchat ligne : lignes) {
                ligne.setCommande(this);
            }
        }
    }
}
