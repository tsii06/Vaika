package com.example.vaika.repo;

import com.example.vaika.modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VenteRepository extends JpaRepository<Vente, Long> {

}
