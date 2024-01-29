package com.example.vaika.controller;

import com.example.vaika.modele.Annonce;
import com.example.vaika.modele.Recherche;
import com.example.vaika.modele.Statistique;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.AnnonceRepository;
import com.example.vaika.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController

public class AnnonceController {

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/annonce")
    Annonce newAnnonce(@RequestBody Annonce newAnnonce) {
        return annonceRepository.save(newAnnonce);
    }

    @GetMapping("/annonces")
    List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }

    @GetMapping("/annonce/{id}")
    ResponseEntity<Annonce> getAnnonceById(@PathVariable(value = "id") Long annonceId) {
        Optional<Annonce> annonce = annonceRepository.findById(annonceId);
        if (annonce.isPresent()) {
            return ResponseEntity.ok().body(annonce.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/annonces/utilisateur/{idUtilisateur}")
    ResponseEntity<List<Annonce>> getAnnoncesByUtilisateurId(@PathVariable(value = "idUtilisateur") Long idUtilisateur) {
        List<Annonce> annonces = annonceRepository.findByUtilisateurIdUtilisateur(idUtilisateur);

        if (!annonces.isEmpty()) {
            return ResponseEntity.ok().body(annonces);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/annonce/statut/{statut}")
    ResponseEntity<List<Annonce>> getAnnonceByStatut(@PathVariable(value = "statut") int idStatut) {
        List<Annonce> annonces = annonceRepository.findAnnoncesByStatut(idStatut);

        if (!annonces.isEmpty()) {
            return ResponseEntity.ok().body(annonces);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/annonce/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable(value = "id") Long annonceId,
                                                 @RequestBody Annonce annonceDetails) {
        Optional<Annonce> optionalAnnonce = annonceRepository.findById(annonceId);
        if (optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            annonce.setDateAnnonce(annonceDetails.getDateAnnonce());
            annonce.setUtilisateur(annonceDetails.getUtilisateur());
            annonce.setVoiture(annonceDetails.getVoiture());
            annonce.setStatut(annonceDetails.getStatut());
            annonce.setDescription(annonceDetails.getDescription());

            final Annonce updatedAnnonce = annonceRepository.save(annonce);
            return ResponseEntity.ok(updatedAnnonce);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PatchMapping("/annonce/{id}/statut")
    public ResponseEntity<Annonce> updateAnnonceStatus(@PathVariable(value = "id") Long annonceId,
                                                       @RequestParam(value = "statut") int nouveauStatut) {
        Optional<Annonce> optionalAnnonce = annonceRepository.findById(annonceId);
        if (optionalAnnonce.isPresent()) {
            Annonce annonce = optionalAnnonce.get();
            annonce.setStatut(nouveauStatut);

            final Annonce updatedAnnonce = annonceRepository.save(annonce);
            return ResponseEntity.ok(updatedAnnonce);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/annonce/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable(value = "id") Long annonceId) {
        Optional<Annonce> annonce = annonceRepository.findById(annonceId);
        if (annonce.isPresent()) {
            annonceRepository.delete(annonce.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/recherche")
    ResponseEntity<List<Annonce>> rechercheAvancee(@RequestBody Recherche recherche) {
        List<Annonce> annonces = annonceService.rechercheAvance(recherche);

        if (!annonces.isEmpty()) {
            return ResponseEntity.ok().body(annonces);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
