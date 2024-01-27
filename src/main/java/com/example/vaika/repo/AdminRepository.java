package com.example.vaika.repo;

import com.example.vaika.modele.Admin;
import com.example.vaika.modele.Carburant;
import com.example.vaika.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByNom(String nom);
}