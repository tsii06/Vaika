package com.example.vaika.controller;

import com.example.vaika.modele.Carburant;
import com.example.vaika.repo.CarburantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarburantController {

    @Autowired
    private CarburantRepository carburantRepository;

    @PostMapping("/carburant")
    public Carburant newCarburant(@RequestBody Carburant newCarburant) {
        return carburantRepository.save(newCarburant);
    }

    @GetMapping("/carburants")
    public List<Carburant> getAllCarburants() {
        return carburantRepository.findAll();
    }

    @GetMapping("/carburant/{id}")
    public ResponseEntity<Carburant> getCarburantById(@PathVariable(value = "id") Long carburantId) {
        Optional<Carburant> carburant = carburantRepository.findById(carburantId);
        if (carburant.isPresent()) {
            return ResponseEntity.ok().body(carburant.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/carburant/{id}")
    public ResponseEntity<Carburant> updateCarburant(@PathVariable(value = "id") Long carburantId,
                                                     @RequestBody Carburant carburantDetails) {
        Optional<Carburant> optionalCarburant = carburantRepository.findById(carburantId);
        if (optionalCarburant.isPresent()) {
            Carburant carburant = optionalCarburant.get();
            carburant.setNom(carburantDetails.getNom());

            final Carburant updatedCarburant = carburantRepository.save(carburant);
            return ResponseEntity.ok(updatedCarburant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/carburant/{id}")
    public ResponseEntity<Void> deleteCarburant(@PathVariable(value = "id") Long carburantId) {
        Optional<Carburant> carburant = carburantRepository.findById(carburantId);
        if (carburant.isPresent()) {
            carburantRepository.delete(carburant.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
