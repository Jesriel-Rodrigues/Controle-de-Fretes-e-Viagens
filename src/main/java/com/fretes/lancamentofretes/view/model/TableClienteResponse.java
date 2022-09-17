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

    private Long tblClienteId;

    private EixoResponse eixo;

    private ClienteResponse clientes;

    private Double diaria;

    private Double valorKm;
}
