package com.fretes.lancamentofretes.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "bonus_veiculo")
@Data
@Builder
public class BonusVeiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean largada;

    private boolean diaria;

    private boolean pernoiteVeiculo;

    private boolean pernoiteTrip;

    private boolean vlrAjudante;

    private boolean vlrEntrega;

    private boolean valorKm;

    private Double porcentagemBonus;

    @OneToOne
    private TableCliente tableCliente;
    
}
