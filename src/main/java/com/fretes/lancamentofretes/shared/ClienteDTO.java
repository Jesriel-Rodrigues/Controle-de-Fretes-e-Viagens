package com.fretes.lancamentofretes.shared;

import java.util.List;

import com.fretes.lancamentofretes.models.entities.Eixo;

import lombok.Data;

public @Data class ClienteDTO {
    
    private Long id;

    private String nome;

    private List<Eixo> eixos;

}
