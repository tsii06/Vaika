package com.example.vaika.repo;

import com.example.vaika.modele.Annonce;
import com.example.vaika.modele.Recherche;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long>, JpaSpecificationExecutor<Annonce> {
    List<Annonce> findByUtilisateurIdUtilisateur(Long idUtilisateur);
    List<Annonce> findAnnoncesByStatut(int statuts);

}
