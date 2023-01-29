package com.fretes.lancamentofretes.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableClientePostRequest {
    

    @NotNull(message = "Não pode cadastrar com id do cliente vazio")
    private Long clientesId;

    @NotNull(message = "Não pode cadastrar com id do eixo vazio")
    private Long eixoId;

    // @NotBlank(message = "Não pode cadastrar valor da diaria vazio")
    private Double diaria;

    // @NotBlank(message = "Não pode cadastrar valor do km vazio")
    private Double valorKm;

    private Double largada;

    private Double pernoiteVeiculo;

    private Double pernoiteTrip;

    private Double franquiaKm;

    private Double vlrAjudante;

    private Double vlrEntrega;

    private Double bonusDeVeiculo;

    private Double vlrFixoMensal;

}
