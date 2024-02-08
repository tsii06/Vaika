package com.example.vaika.repo;

import com.example.vaika.modele.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FavorisRepository extends JpaRepository<Favoris, Long> {
    List<Favoris> findByUtilisateurIdUtilisateur(Long utilisateurId);

    Long countByAnnonceIdAnnonce(Long idAnnonce);
}

