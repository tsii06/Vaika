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

    @GetMapping("/statByDate")
    public List<Statistique> getByDate() {
        String customQuery = "select sum(nombre) as nombre,date_vendu from annonce_vendu group by date_vendu";
        return statistiqueService.getVenteGroupByDate(customQuery);
    }

    @GetMapping("/statByUtilisateur")
    public List<Statistique> getByUtilisateur() {
        String customQuery = " select sum(nombre) as nombre, nom from annonce_vendu group by nom";
        return statistiqueService.getBestSeller(customQuery);
    }




}