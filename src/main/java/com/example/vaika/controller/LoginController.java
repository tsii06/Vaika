package com.example.vaika.controller;

import com.example.vaika.config.Data;
import com.example.vaika.config.JwtUtil;
import com.example.vaika.modele.Utilisateur;
import com.example.vaika.service.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UtilisateurService utilisateurService;
    private final JwtUtil jwtUtil;

    @Autowired  // Ajout de l'annotation @Autowired pour l'injection de dépendance
    public LoginController(UtilisateurService utilisateurService,JwtUtil jwtUtil) {
        this.utilisateurService = utilisateurService;
        this.jwtUtil=jwtUtil;
    }

    @PostMapping("/auth")
    public ResponseEntity<Data> login(@RequestBody Utilisateur user) {
        Utilisateur u = utilisateurService.login(user);
        String token = JwtUtil.createToken(u);
        return ResponseEntity.ok(new Data(u, token, "Welcome"));
    }
    @PostMapping("/login/logout")
    public ResponseEntity<Data> logout(HttpServletRequest request) {
        try {
            String token = getTokenFromRequest(request);
            jwtUtil.addToBlacklist(token);
            return ResponseEntity.ok(new Data(null,null,"Déconnexion réussie"));
        } catch (RuntimeException e){
            return ResponseEntity.ok(new Data(null,null,e.getMessage()));
        }
    }
    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
