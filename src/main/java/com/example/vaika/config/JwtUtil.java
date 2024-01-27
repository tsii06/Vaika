package com.example.vaika.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.vaika.modele.Admin;
import com.example.vaika.modele.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtUtil {
    private Set<String> blacklistedTokens = new HashSet<>();
    public static String createToken(Utilisateur user){
        Date now = new Date();
        Date validity = new Date(now.getTime()+3_600_000);

        return JWT.create()
                .withIssuer(user.getNom())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("id",user.getIdUtilisateur())
                .sign(Algorithm.HMAC256("secret"));
    }

    public Authentication validToken(String token){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Utilisateur user = new Utilisateur(decodedJWT.getClaim("id").asLong(),decodedJWT.getIssuer());

        return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
    }
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
    public void addToBlacklist(String token) {
        blacklistedTokens.add(token);
    }
}
