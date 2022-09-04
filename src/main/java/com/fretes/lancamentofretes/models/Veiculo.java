package com.fretes.lancamentofretes.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "veiculo")
public class Veiculo {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long veiculoId;

    private String placa;

    @OneToOne
    @JoinColumn(name = "eixo_id")
    private Eixo eixo;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<TableFretes> tableFretes;
}
