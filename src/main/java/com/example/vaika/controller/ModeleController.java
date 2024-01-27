package com.example.vaika.controller;

import com.example.vaika.modele.Modele;
import com.example.vaika.repo.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ModeleController {

    @Autowired
    private ModeleRepository modeleRepository;

    @PostMapping("/modele")
    public Modele newModele(@RequestBody Modele newModele) {
        return modeleRepository.save(newModele);
    }

    @GetMapping("/modeles")
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    @GetMapping("/modele/{id}")
    public ResponseEntity<Modele> getModeleById(@PathVariable(value = "id") Long modeleId) {
        Optional<Modele> modele = modeleRepository.findById(modeleId);
        if (modele.isPresent()) {
            return ResponseEntity.ok().body(modele.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/modele/{id}")
    public ResponseEntity<Modele> updateModele(@PathVariable(value = "id") Long modeleId,
                                               @RequestBody Modele modeleDetails) {
        Optional<Modele> optionalModele = modeleRepository.findById(modeleId);
        if (optionalModele.isPresent()) {
            Modele modele = optionalModele.get();
            modele.setNom(modeleDetails.getNom());

            final Modele updatedModele = modeleRepository.save(modele);
            return ResponseEntity.ok(updatedModele);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/modele/{id}")
    public ResponseEntity<Void> deleteModele(@PathVariable(value = "id") Long modeleId) {
        Optional<Modele> modele = modeleRepository.findById(modeleId);
        if (modele.isPresent()) {
            modeleRepository.delete(modele.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
