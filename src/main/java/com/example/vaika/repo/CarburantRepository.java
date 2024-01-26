package com.example.vaika.repo;

import com.example.vaika.modele.Carburant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarburantRepository extends JpaRepository<Carburant, Long> {
    Carburant findByIdCarburant(long id);
}
