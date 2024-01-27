package com.example.vaika.controller;

import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.UtilisateurRepository;
import com.example.vaika.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private UtilisateurService auth;

    @PostMapping("/utilisateur")
    Utilisateur newUtilisateur(@RequestBody Utilisateur newUtilisateur) {
        return utilisateurRepository.save(newUtilisateur);
    }

    @GetMapping("/utilisateurs")
    List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") Long utilisateurId) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(utilisateurId);
        if (utilisateur.isPresent()) {
            return ResponseEntity.ok().body(utilisateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/utilisateur/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long utilisateurId,
                                                         @RequestBody Utilisateur utilisateurDetails) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(utilisateurId);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setNom(utilisateurDetails.getNom());
            utilisateur.setAdresse(utilisateurDetails.getAdresse());
            utilisateur.setEmail(utilisateurDetails.getEmail());
            utilisateur.setContact(utilisateurDetails.getContact());
            utilisateur.setMdp(utilisateurDetails.getMdp());
            utilisateur.setCin(utilisateurDetails.getCin());

            final Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/utilisateur/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable(value = "id") Long utilisateurId) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(utilisateurId);
        if (utilisateur.isPresent()) {
            utilisateurRepository.delete(utilisateur.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
