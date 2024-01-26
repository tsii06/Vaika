package com.example.vaika.modele;

import java.time.LocalDateTime;

public class Message {

    private String senderId; // ID de l'utilisateur qui envoie le message
    private String content;
    private LocalDateTime heure_envoi;

    public Message(){}

    public Message(String senderId,String content,LocalDateTime t){
        this.senderId=senderId;
        this.content=content;
        this.heure_envoi = t;
    }

    public String getSenderId(){return  this.senderId;}
    public void setSenderId(String senderId){
        this.senderId=senderId;
    }

    public String getContent(){return this.content;}
    public void setContent(String msg){
        this.content=msg;
    }

    public LocalDateTime getHeure_envoi(){return  this.heure_envoi;}

    public void setHeure_envoi(LocalDateTime time){
        this.heure_envoi=time;
    }



}

