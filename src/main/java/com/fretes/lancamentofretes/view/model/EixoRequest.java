package com.fretes.lancamentofretes.view.model;


import javax.validation.constraints.NotNull;

import lombok.Data;

public @Data class EixoRequest {

    private Long eixoId;

    @NotNull(message = "O nome do eixo nao pode ser vazio")
    private String nome;
}
