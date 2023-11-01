package com.fretes.lancamentofretes.view.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fretes.lancamentofretes.config.security.TokenService;
import com.fretes.lancamentofretes.services.AutenticationService;
import com.fretes.lancamentofretes.view.model.AutenticatePost;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("autenticate")
public class AutenticacaoController {
    
    @Autowired
    AutenticationService autenticationService;

    @Autowired
    AuthenticationManager authenticationManager;

    private final TokenService tokenService;


    @PostMapping
    public ResponseEntity<?> autenticar( @RequestBody @Valid AutenticatePost autenticar) {
        
        Authentication token = new UsernamePasswordAuthenticationToken(autenticar.getEmail(), autenticar.getSenha());
        Authentication authentication = authenticationManager.authenticate(token);

        Map<String, String> generatedToken = tokenService.tokenCreate((User) authentication.getPrincipal());

        return ResponseEntity.ok(generatedToken);
    }
}
