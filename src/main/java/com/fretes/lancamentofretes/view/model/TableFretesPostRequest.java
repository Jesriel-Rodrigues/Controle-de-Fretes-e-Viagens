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
public class TableFretesPostRequest {
    
    private Long tableFretesId;

    @NotNull(message = "Não pode cadastrar com id do veiculo vazio!")
    private Long veiculoId;

    @NotNull(message = "Não pode cadastrar com id do cliente vazio!")
    private Long clientesId;

    @NotBlank(message = "Quantidade de dias não pode ser vazio!")
    private Long diasViagem;

    @NotBlank(message = "Quantidade de quilometro rodado não pode ser vazio!")
    private Long kmRodado;

    private Double valorFrete;
}
