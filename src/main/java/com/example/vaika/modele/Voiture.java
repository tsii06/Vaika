package com.example.vaika.modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;

    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idModele")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "idCarburant")
    private Carburant carburant;

    private int annee;
    private float kilometrage;
    private int nombrePlace;
    private float prix;

    // Constructors

    public Voiture() {
    }

    public Voiture(Marque marque, Categorie categorie, Modele modele, Carburant carburant, int annee, float kilometrage, int nombrePlace, float prix) {
        this.marque = marque;
        this.categorie = categorie;
        this.modele = modele;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.nombrePlace = nombrePlace;
        this.prix = prix;
    }

    // Getter and Setter methods

    public Long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public float getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(float kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }





}

