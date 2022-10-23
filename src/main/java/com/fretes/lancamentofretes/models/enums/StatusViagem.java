package com.fretes.lancamentofretes.models.enums;

public enum StatusViagem {
    PENDENTE(0,"Pendente"),
    FINALIZADA(1,"Finalizada");

    private Integer value;
    private String description;

    
    private StatusViagem(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
