package com.fretes.lancamentofretes.shared;

import java.util.List;

import com.fretes.lancamentofretes.models.Eixo;

public class ClienteDTO {
    
    private Long id;

    private String nome;

    private List<Eixo> eixos;



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

    public List<Eixo> getEixos() {
        return eixos;
    }

    public void setEixos(List<Eixo> eixos) {
        this.eixos = eixos;
    }

}
