package com.example.vaika.modele;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnnonce;

    private LocalDateTime dateAnnonce;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idVoiture")
    private Voiture voiture;

    private int statut;
    private String description;

    // Constructors

    public Annonce() {
    }

    public Annonce(LocalDateTime dateAnnonce, Utilisateur utilisateur, Voiture voiture, int statut, String description) {
        this.dateAnnonce = dateAnnonce;
        this.utilisateur = utilisateur;
        this.voiture = voiture;
        this.statut = statut;
        this.description = description;
    }

    // Getter and Setter methods

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public LocalDateTime getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(LocalDateTime dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
