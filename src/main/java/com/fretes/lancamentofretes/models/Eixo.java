package com.fretes.lancamentofretes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Eixos")
public @Data class Eixo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long eixoId;

    private String nome;

    private Double Diaria;

    private Double valorKm;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

}
