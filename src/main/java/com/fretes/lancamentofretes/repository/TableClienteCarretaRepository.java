package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fretes.lancamentofretes.models.entities.TableClienteCarreta;


@Repository
public interface TableClienteCarretaRepository extends JpaRepository<TableClienteCarreta, Long>{
    
}
