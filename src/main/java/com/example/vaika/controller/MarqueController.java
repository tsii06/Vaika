package com.example.vaika.controller;

import com.example.vaika.modele.Marque;
import com.example.vaika.repo.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class MarqueController {

    @Autowired
    private MarqueRepository marqueRepository;

    @PostMapping("/marque")
    public Marque newMarque(@RequestBody Marque newMarque) {
        return marqueRepository.save(newMarque);
    }

    @GetMapping("/marques")
    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    @GetMapping("/marque/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable(value = "id") Long marqueId) {
        Optional<Marque> marque = marqueRepository.findById(marqueId);
        if (marque.isPresent()) {
            return ResponseEntity.ok().body(marque.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/marque/{id}")
    public ResponseEntity<Marque> updateMarque(@PathVariable(value = "id") Long marqueId,
                                               @RequestBody Marque marqueDetails) {
        Optional<Marque> optionalMarque = marqueRepository.findById(marqueId);
        if (optionalMarque.isPresent()) {
            Marque marque = optionalMarque.get();
            marque.setNom(marqueDetails.getNom());

            final Marque updatedMarque = marqueRepository.save(marque);
            return ResponseEntity.ok(updatedMarque);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/marque/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable(value = "id") Long marqueId) {
        Optional<Marque> marque = marqueRepository.findById(marqueId);
        if (marque.isPresent()) {
            marqueRepository.delete(marque.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
