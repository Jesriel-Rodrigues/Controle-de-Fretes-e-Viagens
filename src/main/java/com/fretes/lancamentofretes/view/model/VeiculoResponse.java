package com.fretes.lancamentofretes.view.model;

import com.fretes.lancamentofretes.models.Eixo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VeiculoResponse {
    
    private Long veiculoId;

    private String placa;
    
    private Eixo eixo;
}
