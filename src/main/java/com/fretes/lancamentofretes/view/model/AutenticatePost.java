package com.fretes.lancamentofretes.view.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutenticatePost {


    @NotNull(message = "Não pode autenticar com email vazio")
    private String email;

    @NotNull(message = "Não pode autenticar com senha vazia")
    private String senha;
}
