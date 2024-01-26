package com.example.vaika.controller;

import com.example.vaika.modele.Statistique;
import com.example.vaika.service.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StatistiqueController {

    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping("/statistique")
    public List<Statistique[]> getCustomStatistiques() {
        String customQuery = "SELECT * FROM annonce_vendu";
        return statistiqueService.getVenteGroupByDate(customQuery);
    }


}