package com.example.vaika.controller;
import com.example.vaika.modele.Categorie;
import com.example.vaika.repo.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CategorieController {

    @Autowired
    private CategorieRepository categorieRepository;

    @PostMapping("/categorie")
    Categorie newCategorie(@RequestBody Categorie newCategorie) {
        return categorieRepository.save(newCategorie);
    }

    @GetMapping("/categories")
    List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping("/categorie/{id}")
    ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") Long categorieId) {
        Optional<Categorie> categorie = categorieRepository.findById(categorieId);
        if (categorie.isPresent()) {
            return ResponseEntity.ok().body(categorie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/categorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long categorieId,
                                                     @RequestBody Categorie categorieDetails) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(categorieId);
        if (optionalCategorie.isPresent()) {
            Categorie categorie = optionalCategorie.get();
            categorie.setNom(categorieDetails.getNom());

            final Categorie updatedCategorie = categorieRepository.save(categorie);
            return ResponseEntity.ok(updatedCategorie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable(value = "id") Long categorieId) {
        Optional<Categorie> categorie = categorieRepository.findById(categorieId);
        if (categorie.isPresent()) {
            categorieRepository.delete(categorie.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
