package com.madrasati.backend.controller;

import com.madrasati.backend.model.Matiere;
import com.madrasati.backend.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matieres")
class MatiereController {
    @Autowired
    private MatiereService service;

    @GetMapping
    public List<Matiere> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Matiere save(@RequestBody Matiere matiere) {
        return service.save(matiere);
    }

    @PutMapping("/{id}")
    public Matiere update(@PathVariable Long id, @RequestBody Matiere matiere) {
        matiere.setId(id);
        return service.save(matiere);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}