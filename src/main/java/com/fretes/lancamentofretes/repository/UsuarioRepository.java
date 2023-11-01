package com.fretes.lancamentofretes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fretes.lancamentofretes.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

    Optional<Usuario> findByEmail(String username);
    
}
