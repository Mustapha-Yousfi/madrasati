package com.madrasati.backend.service;

import com.madrasati.backend.model.Eleve;
import com.madrasati.backend.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService {
    @Autowired
    private EleveRepository repository;

    public List<Eleve> findAll() {
        return repository.findAll();
    }

    public Optional<Eleve> findById(Long eleveId) {
        return repository.findById(eleveId);
    }

    public Eleve save(Eleve eleve) {
        return repository.save(eleve);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}