package com.madrasati.backend.controller;

import com.madrasati.backend.model.Eleve;
import com.madrasati.backend.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/eleves")
public class EleveController {

    @Autowired
    private EleveService service;

    @GetMapping
    public List<Eleve> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Eleve create(@RequestBody Eleve eleve) {
        return service.save(eleve);
    }

    @GetMapping(path = "/{id}")
    public Eleve get(@PathVariable("id") Long eleveId) {
        return service.findById(eleveId)
                .orElseThrow(() -> new NoSuchElementException("Eleve with id " + eleveId + " not found"));
    }

    @PutMapping("/{id}")
    public Eleve update(@PathVariable Long id, @RequestBody Eleve eleve) {
        eleve.setId(id);
        return service.save(eleve);
    }


    // Moved to ControllerExceptionHandler to be shared by all controllers
//    @ExceptionHandler(NoSuchElementException.class)
//    public ErrorResponse notFound(NoSuchElementException ex) {
//        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
//    }
}
