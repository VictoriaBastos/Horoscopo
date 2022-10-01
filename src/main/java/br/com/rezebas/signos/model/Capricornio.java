package br.com.rezebas.signos.model;

import br.com.rezebas.signos.enums.ascendentes.CapricornioAscendente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capricornio implements Signo {

    private String nomeSigno;
    private CapricornioAscendente ascendente;
    private String descricao;

    @Override
    public String findAscendente(String signoSolar, LocalTime horaNascimento) {
        for (CapricornioAscendente ascendente : CapricornioAscendente.values()) {
            if(horaNascimento.isAfter(ascendente.getStartTime()) && horaNascimento.isBefore(ascendente.getEndTime())){
                return ascendente.getAscendente();
            }
        }
        return "Dados incorretos, signo nao localizado.";
    }
}
