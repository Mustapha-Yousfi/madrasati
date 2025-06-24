package com.madrasati.backend.controller;

import com.madrasati.backend.model.Utilisateur;
import com.madrasati.backend.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
class UtilisateurController {
    @Autowired
    private UtilisateurService service;

    @GetMapping
    public List<Utilisateur> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Utilisateur save(@RequestBody Utilisateur user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur user) {
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}