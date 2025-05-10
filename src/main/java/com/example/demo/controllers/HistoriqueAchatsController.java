package com.example.demo.controllers;

import com.example.demo.beans.HistoriqueAchats;
import com.example.demo.services.HistoriqueAchatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historiques")
@CrossOrigin
public class HistoriqueAchatsController {

    @Autowired
    private HistoriqueAchatsService service;

    @GetMapping
    public List<HistoriqueAchats> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
