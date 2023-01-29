package com.fretes.lancamentofretes.view.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableClienteResponse {

    private Long tblClienteId;

    @JsonIgnore
    private EixoResponse eixo;

    @JsonIgnore
    private ClienteResponse clientes;

    private Double diaria;

    private Double largada;

    private Double pernoiteVeiculo;

    private Double pernoiteTrip;

    private Double franquiaKm;

    private Double vlrAjudante;

    private Double vlrEntrega;

    private Double bonusDeVeiculo;

    private Double vlrFixoMensal;

    private Double valorKm;
}
