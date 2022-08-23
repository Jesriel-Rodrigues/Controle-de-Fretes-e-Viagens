package com.fretes.lancamentofretes.view.model;


import lombok.Data;

public @Data class EixoRequest {

    private String nome;

    private Double Diaria;

    private Double valorKm;

    private Long clienteId;
}
