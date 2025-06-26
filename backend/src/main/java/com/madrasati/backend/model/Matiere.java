package com.madrasati.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @ManyToMany
    private List<Utilisateur> enseignants;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Utilisateur> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Utilisateur> enseignants) {
        this.enseignants = enseignants;
    }
}