package com.fretes.lancamentofretes.view.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fretes.lancamentofretes.models.entities.Clientes;
import com.fretes.lancamentofretes.models.entities.Veiculo;

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

    @JsonIgnore
    private Veiculo veiculo;

    @JsonIgnore
    private Clientes clientes;

    private Long diasViagem;

    private Long kmRodado;

    private Double valorFrete;
    
}
