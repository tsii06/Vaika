package com.example.vaika.repo;

import com.example.vaika.modele.Annonce;
import com.example.vaika.modele.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotosRepository extends JpaRepository<Photos, Long> {
    List<Photos> findByIdAnnonce(int idAnnonce);
}
