package com.example.vaika.service;

import com.example.vaika.modele.Statistique;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.repo.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatistiqueService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StatistiqueService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Statistique> getVenteGroupByDate(String customQuery) {
        return jdbcTemplate.query(customQuery, (resultSet, rowNum) -> {
            int nombreVentes = resultSet.getInt("nombre");
            LocalDate jourVente = resultSet.getDate("date_vendu").toLocalDate();
            return new Statistique(nombreVentes, jourVente);
        });
    }
    public List<Statistique> getBestSeller(String customQuery) {
        return jdbcTemplate.query(customQuery, (resultSet, rowNum) -> {
            int nombreVentes = resultSet.getInt("nombre");
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(resultSet.getString("nom"));
            return new Statistique(nombreVentes, utilisateur);
        });
    }


}
