package com.example.vaika.modele;

import jakarta.persistence.*;

@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "idAnnonce")
    Long idAnnonce;

    @Lob
    @Column(columnDefinition = "TEXT")
    String path;

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Photos() {

    }

    public Photos(Long idAnnonce, String path) {
        this.idAnnonce = idAnnonce;
        this.path = path;
    }
}
