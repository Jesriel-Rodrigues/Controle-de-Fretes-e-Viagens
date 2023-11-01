package com.fretes.lancamentofretes.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
    
    public Map<String, String> tokenCreate( User usuario){
        try {

            Algorithm alrorithm = Algorithm.HMAC256("My_Scret_Key");

            String Jwt =  JWT.create()
                .withIssuer("ControleFretes")
                .withSubject(usuario.getUsername())
                .withExpiresAt(expirationDate())
                .sign(alrorithm);

            Map<String, String> response = new HashMap<>();
            response.put("token", Jwt);
            return response;
        
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token: " + e);
        }
    }

    public String getSubject( String tokenJWT){
        try {
                Algorithm alrorithm = Algorithm.HMAC256("My_Scret_Key");
                return JWT.require(alrorithm)
                                .withIssuer("ControleFretes")
                                .build()
                                .verify(tokenJWT)
                                .getSubject();
        } catch (JWTVerificationException exception) {
                throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    public Instant expirationDate(){
        return LocalDateTime.now().plusHours(8L).toInstant(ZoneOffset.of("-03:00"));
    }
}
