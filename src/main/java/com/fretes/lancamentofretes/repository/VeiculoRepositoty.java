package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fretes.lancamentofretes.models.entities.Veiculo;

public interface VeiculoRepositoty extends JpaRepository<Veiculo, Long>{
    
}
