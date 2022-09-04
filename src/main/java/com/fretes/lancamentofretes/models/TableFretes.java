package com.fretes.lancamentofretes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
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

    private Double valorFrete;
}