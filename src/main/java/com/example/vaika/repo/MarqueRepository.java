package com.example.vaika.repo;

import com.example.vaika.modele.Carburant;
import com.example.vaika.modele.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {

}