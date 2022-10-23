package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fretes.lancamentofretes.models.TableClienteCarreta;


@Repository
public interface TableClienteCarretaRepository extends JpaRepository<TableClienteCarreta, Long>{
    
}
