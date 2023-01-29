package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fretes.lancamentofretes.models.entities.TableCliente;

@Repository
public interface TableClienteRepository extends JpaRepository<TableCliente, Long>{
    
}
