package com.example.demo.beans;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String contact;
    private String qualiteService;
    private Double note;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    @JsonManagedReference // Prevents infinite recursion
    private List<CommandeAchat> commandes;

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getQualiteService() { return qualiteService; }
    public void setQualiteService(String qualiteService) { this.qualiteService = qualiteService; }

    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }

    public List<CommandeAchat> getCommandes() { return commandes; }
    public void setCommandes(List<CommandeAchat> commandes) { this.commandes = commandes; }
}
