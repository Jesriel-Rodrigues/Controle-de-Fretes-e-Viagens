package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fretes.lancamentofretes.models.entities.Eixo;

@Repository
public interface EixoRepository  extends JpaRepository <Eixo, Long>{
    
}
