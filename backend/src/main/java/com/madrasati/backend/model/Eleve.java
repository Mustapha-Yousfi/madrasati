package com.madrasati.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "eleve")
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Classe classe;

    @ManyToMany
    private List<Utilisateur> responsables;

    // getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Utilisateur> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Utilisateur> responsables) {
        this.responsables = responsables;
    }
}
