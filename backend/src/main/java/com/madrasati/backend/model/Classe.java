package com.madrasati.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String anneeScolaire;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToOne
    private Utilisateur profPrincipal;

    public enum Niveau {
        CP, CE1, CE2, CM1, CM2,
        SIXIEME, CINQUIEME, QUATRIEME, TROISIEME,
        SECONDE, PREMIERE, TERMINALE
    }

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

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Utilisateur getProfPrincipal() {
        return profPrincipal;
    }

    public void setProfPrincipal(Utilisateur profPrincipal) {
        this.profPrincipal = profPrincipal;
    }
}
