package com.madrasati.backend.service;

import com.madrasati.backend.exception.EstablishmentNotFoundException;
import com.madrasati.backend.model.Establishment;
import com.madrasati.backend.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstablishmentService {
    EstablishmentRepository establishmentRepository;


    @Autowired
    public void setEstablishmentRepository(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
        System.out.println("Establishement Repository Set");
    }

    public  Establishment findEstablishment(long id) {



        if (id == 1) {
            Establishment alkindi = new Establishment();
            alkindi.setName("Al Kindi");
            alkindi.setAddress("Rue Sully");
            return alkindi;
        } else {
            throw new EstablishmentNotFoundException("Establishment not found");
        }
    }
}
