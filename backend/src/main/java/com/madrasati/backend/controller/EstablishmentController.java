package com.madrasati.backend.controller;

import com.madrasati.backend.exception.EstablishmentNotFoundException;
import com.madrasati.backend.model.Establishment;
import com.madrasati.backend.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/establishment")
public class EstablishmentController {
    private EstablishmentService service;

    @Autowired
    public void setEstablishmentService(EstablishmentService establishmentService) {
        this.service = establishmentService;
        System.out.println("Establishement Service  Set");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Establishment> getEstablishment(@PathVariable("id") long id) {

        try {
            return new ResponseEntity<Establishment>(service.findEstablishment(id), HttpStatus.OK);
        } catch (EstablishmentNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
        }
    }
}
