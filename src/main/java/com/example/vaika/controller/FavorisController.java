package com.example.vaika.controller;

import com.example.vaika.modele.Favoris;
import com.example.vaika.repo.FavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavorisController {

    @Autowired
    private FavorisRepository favorisRepository;


    @GetMapping("/favoris/{idUtilisateur}")
    public ResponseEntity<List<Favoris>> getByUtilisateur(@PathVariable(value = "idUtilisateur" )Long idUtilisateur) {
        List<Favoris> favorisList = favorisRepository.findByUtilisateurIdUtilisateur(idUtilisateur);
        return new ResponseEntity<>(favorisList, HttpStatus.OK);
    }

    // Endpoint pour créer un favori
    @PostMapping("/favoris")
    public ResponseEntity<Favoris> createFavoris(@RequestBody Favoris favoris) {
        Favoris savedFavoris = favorisRepository.save(favoris);
        return new ResponseEntity<>(savedFavoris, HttpStatus.CREATED);
    }

    // Endpoint pour supprimer un favori par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavoris(@PathVariable Long id) {
        favorisRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/countByAnnonce/{idAnnonce}")
    public ResponseEntity<Long> getCountByAnnonce(@PathVariable(value = "idAnnonce") Long idAnnonce) {
        Long count = favorisRepository.countByAnnonceIdAnnonce(idAnnonce);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
