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
    
    // @NotNull(message = "Não pode cadastrar com id do veiculo vazio")
    // private Long veiculoId;

    @NotNull(message = "Não pode cadastrar com id do cliente vazio")
    private Long clientesId;

    // @NotBlank(message = "Não pode cadastrar valor do frete vazio")
    // private Double valorFrete;

    @NotBlank(message = "Não pode cadastrar valor da diaria vazio")
    private Double diaria;

    @NotBlank(message = "Não pode cadastrar valor do km vazio")
    private Double valorKm;

    @NotNull(message = "Não pode cadastrar com id do eixo vazio")
    private Long eixoId;
}
