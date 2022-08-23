package com.fretes.lancamentofretes.view.model;



import lombok.Data;

public @Data class EixoResponse {

    private Long eixoId;

    private String nome;

    private Double Diaria;

    private Double valorKm;

    private ClienteResponse cliente;
    
}
