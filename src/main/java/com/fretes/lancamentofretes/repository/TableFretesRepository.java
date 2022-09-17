package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fretes.lancamentofretes.models.TableFretes;

@Repository
public interface TableFretesRepository extends JpaRepository<TableFretes, Long>{
    
}
