package com.example.vaika.controller;

import com.example.vaika.modele.*;
import com.example.vaika.repo.*;
import com.example.vaika.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VoitureController {

    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private ModeleRepository modeleRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private CarburantRepository carburantRepository;
    @Autowired
    private VoitureService voitureService;

    @PostMapping("/voiture")
    public Voiture newVoiture(@RequestBody Voiture newVoiture) {
        return voitureRepository.save(newVoiture);
    }

    @GetMapping("/voitures")
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    @GetMapping("/voiture/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable(value = "id") Long voitureId) {
        Optional<Voiture> voiture = voitureRepository.findById(voitureId);
        if (voiture.isPresent()) {
            return ResponseEntity.ok().body(voiture.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PutMapping("/voiture/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable(value = "id") Long voitureId,
                                                 @RequestBody Voiture voitureDetails) {
        Optional<Voiture> optionalVoiture = voitureRepository.findById(voitureId);
        if (optionalVoiture.isPresent()) {
            Voiture voiture = optionalVoiture.get();
            voiture.setMarque(voitureDetails.getMarque());
            voiture.setCategorie(voitureDetails.getCategorie());
            voiture.setModele(voitureDetails.getModele());
            voiture.setCarburant(voitureDetails.getCarburant());
            voiture.setAnnee(voitureDetails.getAnnee());
            voiture.setKilometrage(voitureDetails.getKilometrage());
            voiture.setNombrePlace(voitureDetails.getNombrePlace());
            voiture.setPrix(voitureDetails.getPrix());

            final Voiture updatedVoiture = voitureRepository.save(voiture);
            return ResponseEntity.ok(updatedVoiture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/voiture/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable(value = "id") Long voitureId) {
        Optional<Voiture> voiture = voitureRepository.findById(voitureId);
        if (voiture.isPresent()) {
            voitureRepository.delete(voiture.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
