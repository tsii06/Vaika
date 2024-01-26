package com.example.vaika.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModele;



    private String nom;

    // Constructors

    public Modele() {
    }

    // Getter and Setter methods

    public Long getIdModele() {
        return idModele;
    }

    public void setIdModele(Long idModele){
        this.idModele= idModele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
