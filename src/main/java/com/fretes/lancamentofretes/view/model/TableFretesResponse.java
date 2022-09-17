package com.fretes.lancamentofretes.view.model;

import com.fretes.lancamentofretes.models.Clientes;
import com.fretes.lancamentofretes.models.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableFretesResponse {

    private Long tableFretesId;

    private Veiculo veiculo;

    private Clientes clientes;

    private Long diasViagem;

    private Long kmRodado;

    private Double valorFrete;
    
}
