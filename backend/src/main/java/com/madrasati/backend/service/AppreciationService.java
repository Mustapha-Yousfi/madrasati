package com.madrasati.backend.service;

import com.madrasati.backend.model.Appreciation;
import com.madrasati.backend.repository.AppreciationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppreciationService {
    @Autowired
    private AppreciationRepository repository;

    public List<Appreciation> findAll() {
        return repository.findAll();
    }

    public Appreciation save(Appreciation appreciation) {
        return repository.save(appreciation);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}