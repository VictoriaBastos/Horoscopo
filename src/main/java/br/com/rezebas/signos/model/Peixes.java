package br.com.rezebas.signos.model;

import br.com.rezebas.signos.enums.ascendentes.PeixesAscendente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peixes implements Signo {

    private String nomeSigno;
    private PeixesAscendente ascendente;
    private String descricao;

    @Override
    public String findAscendente(String signoSolar, LocalTime horaNascimento) {
        for (PeixesAscendente ascendente : PeixesAscendente.values()) {
            if(horaNascimento.isAfter(ascendente.getStartTime()) && horaNascimento.isBefore(ascendente.getEndTime())){
                return ascendente.getAscendente();
            }
        }
        return "Dados incorretos, signo nao localizado.";
    }

}
