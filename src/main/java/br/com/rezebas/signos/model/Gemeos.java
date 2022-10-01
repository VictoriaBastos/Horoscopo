package br.com.rezebas.signos.model;

import br.com.rezebas.signos.enums.ascendentes.GemeosAscendente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gemeos implements Signo {

    private String nomeSigno;
    private GemeosAscendente ascendente;
    private String descricao;

    @Override
    public String findAscendente(String signoSolar, LocalTime horaNascimento) {
        for (GemeosAscendente ascendente : GemeosAscendente.values()) {
            if(horaNascimento.isAfter(ascendente.getStartTime()) && horaNascimento.isBefore(ascendente.getEndTime())){
                return ascendente.getAscendente();
            }
        }
        return "Dados incorretos, signo nao localizado.";
    }
}
