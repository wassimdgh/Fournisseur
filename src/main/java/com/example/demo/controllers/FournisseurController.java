package com.example.demo.controllers;

import com.example.demo.beans.Fournisseur;
import com.example.demo.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
@CrossOrigin
public class FournisseurController {

    @Autowired
    private FournisseurService service;

    @GetMapping
    public List<Fournisseur> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Fournisseur getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Fournisseur create(@RequestBody Fournisseur fournisseur) {
        return service.save(fournisseur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Fournisseur update(@PathVariable Long id, @RequestBody Fournisseur updated) {
        Fournisseur fournisseur = service.findById(id);
        if (fournisseur == null) return null;

        fournisseur.setNom(updated.getNom());
        fournisseur.setContact(updated.getContact());

        return service.save(fournisseur);
    }
}
