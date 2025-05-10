package com.example.demo.beans;

import jakarta.persistence.*;

@Entity
public class HistoriqueAchats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fournisseur fournisseur;

    private String produit;
    private int quantite;
    private int delaiLivraison;

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Fournisseur getFournisseur() { return fournisseur; }
    public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }

    public String getProduit() { return produit; }
    public void setProduit(String produit) { this.produit = produit; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public int getDelaiLivraison() { return delaiLivraison; }
    public void setDelaiLivraison(int delaiLivraison) { this.delaiLivraison = delaiLivraison; }
}
