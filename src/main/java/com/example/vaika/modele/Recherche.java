package com.example.vaika.modele;

public class Recherche {
    Long idCategorie;
    Long idMarque;
    Long idModele;
    Long idCarburant;
    double prixmin;
    double prixmax;
    double kilometrage;


    double annee;

    public Recherche(Long idCategorie, Long idMarque, Long idModele, Long idCarburant, double prixmin, double prixmax, double kilometrage, double annee, double nombrePlace) {
        this.idCategorie = idCategorie;
        this.idMarque = idMarque;
        this.idModele = idModele;
        this.idCarburant = idCarburant;
        this.prixmin = prixmin;
        this.prixmax = prixmax;
        this.kilometrage = kilometrage;
        this.annee = annee;
        this.nombrePlace = nombrePlace;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Long getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Long idMarque) {
        this.idMarque = idMarque;
    }

    public Long getIdModele() {
        return idModele;
    }

    public void setIdModele(Long idModele) {
        this.idModele = idModele;
    }

    public Long getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(Long idCarburant) {
        this.idCarburant = idCarburant;
    }

    public double getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(double prixmin) {
        this.prixmin = prixmin;
    }

    public double getPrixmax() {
        return prixmax;
    }

    public void setPrixmax(double prixmax) {
        this.prixmax = prixmax;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getAnnee() {
        return annee;
    }

    public void setAnnee(double annee) {
        this.annee = annee;
    }

    public double getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(double nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    double nombrePlace;
}
