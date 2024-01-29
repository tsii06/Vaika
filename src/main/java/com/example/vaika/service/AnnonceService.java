package com.example.vaika.service;

import com.example.vaika.modele.Annonce;
import com.example.vaika.modele.Recherche;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.modele.Voiture;
import com.example.vaika.repo.AnnonceRepository;
import com.example.vaika.repo.UtilisateurRepository;
import com.example.vaika.repo.VoitureRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;

    public List<Annonce> rechercheAvance(Recherche recherche) {
        Specification<Annonce> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (recherche.getIdMarque() != null) {
                predicates.add(cb.equal(root.get("voiture").get("marque").get("idMarque"), recherche.getIdMarque()));
            }
            if (recherche.getIdModele() != null) {
                predicates.add(cb.equal(root.get("voiture").get("modele").get("idModele"), recherche.getIdModele()));
            }
            if (recherche.getIdCarburant() != null) {
                predicates.add(cb.equal(root.get("voiture").get("carburant").get("idCarburant"), recherche.getIdCarburant()));
            }
            if (recherche.getIdCarburant() != null) {
                predicates.add(cb.equal(root.get("voiture").get("categorie").get("idCategorie"), recherche.getIdCarburant()));
            }

            if (recherche.getPrixmin() != 0) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("voiture").get("prix"), recherche.getPrixmin()));
            } else {
                predicates.add(cb.greaterThanOrEqualTo(root.get("voiture").get("prix"), 0));
            }
            if (recherche.getPrixmax() != 0) {
                predicates.add(cb.lessThanOrEqualTo(root.get("voiture").get("prix"), recherche.getPrixmax()));
            }
            if (recherche.getKilometrage() != 0) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("voiture").get("kilometrage"), recherche.getKilometrage()));
            }
            if (recherche.getAnnee() != 0) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("voiture").get("annee"), recherche.getKilometrage()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        List<Annonce> result = annonceRepository.findAll(spec);
        return result;
    }



}
