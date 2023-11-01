package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fretes.lancamentofretes.models.entities.TableFretes;

public interface TableFretesRepository extends JpaRepository<TableFretes, Long>{
    
}
