package com.fretes.lancamentofretes.models.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    
    private String titulo;

    private Integer status;

    private String mensagem;
}
