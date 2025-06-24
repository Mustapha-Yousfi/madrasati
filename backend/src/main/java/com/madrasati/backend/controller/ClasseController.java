package com.madrasati.backend.controller;

import com.madrasati.backend.model.Classe;
import com.madrasati.backend.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
class ClasseController {
    @Autowired
    private ClasseService service;

    @GetMapping
    public List<Classe> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Classe save(@RequestBody Classe cl) {
        return service.save(cl);
    }

    @PutMapping("/{id}")
    public Classe update(@PathVariable Long id, @RequestBody Classe cl) {
        cl.setId(id);
        return service.save(cl);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}