package com.fretes.lancamentofretes.models.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fretes.lancamentofretes.models.enums.StatusViagem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_fretes")
public class TableFretes {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long tableFretesId;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clientes clientes;

    private LocalDate dataSaida;

    private LocalDate dataRetorno;

    private Double qtdTrip;

    private Double qtdEntrega;

    @Enumerated(EnumType.STRING)
    private StatusViagem status;

    private Long kmRodado;

    private Double valorFrete;
}
