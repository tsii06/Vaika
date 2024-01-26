package com.example.vaika.config;

import com.example.vaika.modele.Utilisateur;

public class Data {
    private Utilisateur user;
    private String token;
    private String message;

    public Data() {
    }

    public Data(Utilisateur user, String token, String message) {
        this.user = user;
        this.token = token;
        this.message = message;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
