package com.example.vaika.modele;

import java.time.LocalDate;

public class Statistique {

    private int nombreVentes;
    private LocalDate jourVente;
    private Utilisateur utilisateur;
    public Statistique(int nombreVentes, LocalDate jourVente) {
        this.nombreVentes = nombreVentes;
        this.jourVente = jourVente;
    }
    public Statistique(int nombreVentes, Utilisateur utilisateur) {
        this.nombreVentes = nombreVentes;
        this.utilisateur = utilisateur;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getNombreVentes() {
        return nombreVentes;
    }

    public void setNombreVentes(int nombreVentes) {
        this.nombreVentes = nombreVentes;
    }

    public LocalDate getJourVente() {
        return jourVente;
    }

    public void setJourVente(LocalDate jourVente) {
        this.jourVente = jourVente;
    }

}
