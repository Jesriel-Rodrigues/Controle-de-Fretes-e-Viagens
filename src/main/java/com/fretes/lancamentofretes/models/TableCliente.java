package com.fretes.lancamentofretes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "table_cliente")
@Data
public class TableCliente {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long tblClienteId;

    private Double diaria;

    private Double valorKm;

    @OneToOne
    @JoinColumn(name = "eixo_id")
    private Eixo eixo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;
}
