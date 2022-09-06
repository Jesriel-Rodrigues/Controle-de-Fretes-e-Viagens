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
public class VeiculoPutRequest {

    // @NotNull(message = "Não pode editar veiculo com id vazio")
    private Long veiculoId;
    
    @NotBlank(message = "Não pode editar veiculo com placa vazia")
    private String placa;

    @NotNull(message = "Não pode editar veiculo com eixo vazio")
    private Long eixoId;
}
