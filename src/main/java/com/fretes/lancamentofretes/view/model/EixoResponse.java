package com.fretes.lancamentofretes.view.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EixoResponse {

    private Long eixoId;

    private String nome;
}
