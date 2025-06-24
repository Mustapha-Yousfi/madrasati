package com.madrasati.backend.service;

import com.madrasati.backend.model.Matiere;
import com.madrasati.backend.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {
    @Autowired
    private MatiereRepository repository;

    public List<Matiere> findAll() {
        return repository.findAll();
    }

    public Matiere save(Matiere matiere) {
        return repository.save(matiere);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}