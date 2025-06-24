package com.madrasati.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bulletin")
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Eleve eleve;

    private String periode;

    @OneToMany
    private List<Appreciation> appreciations;

    // TODO: moyenne calculée ou stockée selon choix métier

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public List<Appreciation> getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(List<Appreciation> appreciations) {
        this.appreciations = appreciations;
    }
}