package com.fretes.lancamentofretes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fretes.lancamentofretes.models.entities.TableCliente;

public interface TableClienteRepository extends JpaRepository<TableCliente, Long>{
    
}
