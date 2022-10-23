package com.fretes.lancamentofretes.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "table_cliente_carreta")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TableClienteCarreta {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long tblCarretaId;

    private Double qtdRodado;

    private Double vlrRota;

    @ManyToOne
    @JoinColumn(name = "table_cliente_id")
    private TableCliente tableCliente;
}
