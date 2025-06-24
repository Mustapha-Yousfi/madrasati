package com.madrasati.backend.service;

import com.madrasati.backend.model.Classe;
import com.madrasati.backend.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository repository;

    public List<Classe> findAll() {
        return repository.findAll();
    }

    public Classe save(Classe cl) {
        return repository.save(cl);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}