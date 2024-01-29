package com.example.vaika.modele;

import jakarta.persistence.*;

@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonce annonce;

    public Favoris() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public Favoris(Long id, Utilisateur utilisateur, Annonce annonce) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.annonce = annonce;
    }
}
