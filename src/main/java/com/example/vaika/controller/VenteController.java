package com.example.vaika.controller;

import com.example.vaika.modele.Vente;
import com.example.vaika.repo.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenteController {

    @Autowired
    private VenteRepository venteRepository;


    // Endpoint pour créer une vente
    @PostMapping("/vente")
    public ResponseEntity<Vente> createVente(@RequestBody Vente vente) {
        Vente savedVente = venteRepository.save(vente);
        return new ResponseEntity<>(savedVente, HttpStatus.CREATED);
    }


}
