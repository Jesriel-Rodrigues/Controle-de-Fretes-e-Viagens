package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fretes.lancamentofretes.models.entities.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    
} 

