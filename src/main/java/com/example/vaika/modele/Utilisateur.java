package com.example.vaika.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    private String nom;
    private String adresse;
    private String email;
    private String contact;
    private String mdp;
    private String cin;

    // Constructors

    // Default constructor
    public Utilisateur() {
    }

    // Constructor with fields
    public Utilisateur(String nom, String adresse, String email, String contact, String mdp, String cin) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.contact = contact;
        this.mdp = mdp;
        this.cin = cin;
    }

    public Utilisateur(Long idUtilisateur,String nom){
        this.idUtilisateur=idUtilisateur;
        this.nom=nom;
    }

    // Getter and Setter methods

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

}
