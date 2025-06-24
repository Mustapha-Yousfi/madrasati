package com.madrasati.backend.controller;

import com.madrasati.backend.model.Appreciation;
import com.madrasati.backend.service.AppreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appreciations")
class AppreciationController {
    @Autowired
    private AppreciationService service;

    @GetMapping
    public List<Appreciation> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Appreciation save(@RequestBody Appreciation appreciation) {
        return service.save(appreciation);
    }

    @PutMapping("/{id}")
    public Appreciation update(@PathVariable Long id, @RequestBody Appreciation appreciation) {
        appreciation.setId(id);
        return service.save(appreciation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
