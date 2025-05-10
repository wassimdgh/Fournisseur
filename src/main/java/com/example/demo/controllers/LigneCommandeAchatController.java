package com.example.demo.controllers;

import com.example.demo.beans.LigneCommandeAchat;
import com.example.demo.services.LigneCommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignes")
@CrossOrigin
public class LigneCommandeAchatController {

    @Autowired
    private LigneCommandeAchatService service;

    @GetMapping
    public List<LigneCommandeAchat> getAll() {
        return service.findAll();
    }
}
