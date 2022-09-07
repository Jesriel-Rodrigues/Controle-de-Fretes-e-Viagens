package com.fretes.lancamentofretes.view.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableClienteResponse {

    private Long tableFretesId;

    private VeiculoResponse veiculo;

    private ClienteResponse clientes;

    private Double valorFrete;
}
