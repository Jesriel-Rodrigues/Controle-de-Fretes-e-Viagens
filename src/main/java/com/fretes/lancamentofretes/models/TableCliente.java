package com.fretes.lancamentofretes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "table_cliente")
@Data
public class TableCliente {
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long tblClienteId;

    private Double largada;

    private Double diaria;

    private Double pernoiteVeiculo;

    private Double pernoiteTrip;

    private Double franquiaKm;

    private Double vlrAjudante;

    private Double vlrEntrega;

    private Double bonusDeVeiculo;

    private Double vlrFixoMensal;

    private Double valorKm;

    @OneToMany(mappedBy = "tableCliente" , cascade = CascadeType.ALL)
    private List<TableClienteCarreta> TableClienteCarretas;

    @OneToOne
    @JoinColumn(name = "eixo_id")
    private Eixo eixo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;
}
