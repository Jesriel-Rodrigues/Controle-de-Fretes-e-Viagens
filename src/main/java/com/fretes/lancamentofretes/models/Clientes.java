package com.fretes.lancamentofretes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "Clientes")
public @Data class Clientes {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<TableCliente> tableClientes;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<TableFretes> tableFretes;
}
