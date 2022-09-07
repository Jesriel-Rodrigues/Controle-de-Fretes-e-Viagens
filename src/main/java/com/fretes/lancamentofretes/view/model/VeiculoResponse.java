package com.fretes.lancamentofretes.view.model;

import com.fretes.lancamentofretes.models.Eixo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponse {
    
    private Long veiculoId;

    private String placa;
    
    private Eixo eixo;
}
