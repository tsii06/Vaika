package com.example.vaika.modele;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur acheteur;
    @ManyToOne
    @JoinColumn(name = "idannonce")
    private Annonce annonce;

    public Vente(Utilisateur acheteur, Annonce annonce, LocalDateTime dateVendu) {
        this.acheteur = acheteur;
        this.annonce = annonce;
        this.dateVendu = dateVendu;
    }

    public Vente() {

    }

    public LocalDateTime getDateVendu() {
        return dateVendu;
    }

    public void setDateVendu(LocalDateTime dateVendu) {
        this.dateVendu = dateVendu;
    }

    private LocalDateTime dateVendu;
    public Utilisateur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Utilisateur acheteur) {
        this.acheteur = acheteur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
