package com.fretes.lancamentofretes.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Entity
@Table(name = "Clientes")
public @Data class Clientes {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nome;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "cliente")
    private List<Eixo> eixos;

}
