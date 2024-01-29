package com.example.vaika.repo;

import com.example.vaika.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // You can add custom query methods here if needed.
    Optional<Utilisateur> findByEmail(String email);

}