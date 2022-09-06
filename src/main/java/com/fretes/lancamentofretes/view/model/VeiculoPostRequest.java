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
public class VeiculoPostRequest {

    @NotBlank(message = "Não pode cadastrar veiculo com placa vazia")
    private String placa;

    @NotNull(message = "Não pode cadastrar veiculo com eixo vazio")
    private Long eixoId;
}
