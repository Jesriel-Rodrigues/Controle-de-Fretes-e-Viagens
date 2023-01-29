package com.fretes.lancamentofretes.Util;

import com.fretes.lancamentofretes.models.entities.TableCliente;
import com.fretes.lancamentofretes.models.entities.Veiculo;
import com.fretes.lancamentofretes.view.model.TableFretesPostRequest;

public class CalculaValores {
    

    public static Double calculaValorFrete( TableCliente tblCliente, TableFretesPostRequest fretePost, Veiculo veiculo ) {

        Long qtdeDiasViagem = fretePost.getDataRetorno().toEpochDay() - fretePost.getDataSaida().toEpochDay();
        Long qtdeNoites = (fretePost.getDataRetorno().toEpochDay() - fretePost.getDataSaida().toEpochDay()) - 1;

        Double vlrTotalFrete = 0D;

        tblCliente.getBonusVeiculo();

        if (tblCliente.getLargada() == null) {
            if (tblCliente.getDiaria() != null) {
                vlrTotalFrete = vlrTotalFrete + (qtdeDiasViagem * tblCliente.getDiaria());
            }
        }else{
            if (tblCliente.getDiaria() != null) {
                vlrTotalFrete = vlrTotalFrete + (((qtdeDiasViagem - 1) * tblCliente.getDiaria()) + tblCliente.getLargada());
            }
        }
        
        if (tblCliente.getPernoiteTrip() != null) {
            vlrTotalFrete = vlrTotalFrete + (qtdeNoites * tblCliente.getPernoiteTrip());
        }

        if (tblCliente.getPernoiteVeiculo() != null) {
            vlrTotalFrete = vlrTotalFrete + (qtdeNoites * tblCliente.getPernoiteVeiculo());
        }

        if (tblCliente.getFranquiaKm() == null) {
            if (tblCliente.getValorKm() != null) {
                vlrTotalFrete = vlrTotalFrete + (fretePost.getKmRodado() * tblCliente.getValorKm());      
            }
        }else {
            if (tblCliente.getValorKm() != null && tblCliente.getFranquiaKm() < fretePost.getKmRodado()) {
                Double rodadoMenosFranquia = fretePost.getKmRodado() - tblCliente.getFranquiaKm();
                vlrTotalFrete = vlrTotalFrete + ((rodadoMenosFranquia) * tblCliente.getValorKm());      
            }
        }

        if (tblCliente.getVlrEntrega() != null) {
            vlrTotalFrete = vlrTotalFrete + (fretePost.getQtdEntrega() * tblCliente.getVlrEntrega());           
        }
         
        return vlrTotalFrete;
    }

}
