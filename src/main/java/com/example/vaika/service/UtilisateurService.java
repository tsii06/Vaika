package com.example.vaika.service;

import com.example.vaika.modele.Admin;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.UtilisateurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    public Utilisateur login(Utilisateur user){
        Utilisateur ur = utilisateurRepository.findByEmail(user.getEmail())
                .orElseThrow(()->new RuntimeException("Unknwn user"));
        if (user.getMdp().equals(ur.getMdp())){
            return ur;
        }
        throw new RuntimeException("Unknwn password");
    }

}
