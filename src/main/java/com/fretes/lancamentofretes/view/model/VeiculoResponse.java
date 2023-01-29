package com.fretes.lancamentofretes.view.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fretes.lancamentofretes.models.entities.Eixo;

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
    
    @JsonIgnore
    private Eixo eixo;
}
