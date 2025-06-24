package com.madrasati.backend.service;

import com.madrasati.backend.model.Utilisateur;
import com.madrasati.backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repository;

    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    public Utilisateur save(Utilisateur user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}