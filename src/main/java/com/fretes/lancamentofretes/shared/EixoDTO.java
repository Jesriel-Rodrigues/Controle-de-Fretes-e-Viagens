package com.fretes.lancamentofretes.shared;

import com.fretes.lancamentofretes.models.entities.Clientes;

import lombok.Data;

public @Data class EixoDTO {

    private Long eixoId;
    
    private String nome;

    private Double Diaria;

    private Double valorKm;

    private Clientes cliente;

}
