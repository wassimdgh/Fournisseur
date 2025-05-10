package com.example.demo.controllers;

import com.example.demo.beans.CommandeAchat;
import com.example.demo.services.CommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande-achats")
@CrossOrigin
public class CommandeAchatController {

    @Autowired
    private CommandeAchatService service;

    // Retrieve all commandes
    @GetMapping
    public List<CommandeAchat> getAll() {
        return service.findAll();
    }

    // Retrieve a single commande by ID
    @GetMapping("/{id}")
    public CommandeAchat getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // Create a new commande
    @PostMapping
    public CommandeAchat create(@RequestBody CommandeAchat commande) {
        return service.save(commande);
    }

    // Delete a commande by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
