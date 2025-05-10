package com.example.demo.services;

import com.example.demo.beans.LigneCommandeAchat;
import com.example.demo.repositories.LigneCommandeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeAchatService {

    @Autowired
    private LigneCommandeAchatRepository ligneCommandeAchatRepository;

    public List<LigneCommandeAchat> findAll() {
        return ligneCommandeAchatRepository.findAll();
    }
}
