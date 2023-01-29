package com.fretes.lancamentofretes.view.model;


import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fretes.lancamentofretes.models.enums.StatusViagem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableFretesPostRequest {
    
    private Long tableFretesId;

    @NotNull(message = "Não pode cadastrar com id do veiculo vazio!")
    private Long veiculoId;

    @NotNull(message = "Não pode cadastrar com id do cliente vazio!")
    private Long clientesId;

    @NotBlank(message = "Não pode cadastrar com data de saida vazio!")
    private LocalDate dataSaida;

    private LocalDate dataRetorno;

    private Double qtdTrip;

    private Double qtdEntrega;

    @NotNull(message = "Status da viagem não pode ser vazio!")
    @Enumerated(EnumType.ORDINAL)
    private StatusViagem status;

    private Long kmRodado;
}
