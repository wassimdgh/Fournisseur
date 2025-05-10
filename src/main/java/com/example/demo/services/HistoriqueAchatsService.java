package com.example.demo.services;

import com.example.demo.beans.HistoriqueAchats;
import com.example.demo.repositories.HistoriqueAchatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueAchatsService {

    @Autowired
    private HistoriqueAchatsRepository repository;

    public List<HistoriqueAchats> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
