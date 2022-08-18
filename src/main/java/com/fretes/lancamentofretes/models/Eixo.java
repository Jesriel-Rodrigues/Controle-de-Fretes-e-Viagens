package com.fretes.lancamentofretes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Eixos")
public class Eixo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    private Double Diaria;

    private Double valorKm;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDiaria() {
        return Diaria;
    }

    public void setDiaria(Double diaria) {
        Diaria = diaria;
    }

    public Double getValorKm() {
        return valorKm;
    }

    public void setValorKm(Double valorKm) {
        this.valorKm = valorKm;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
