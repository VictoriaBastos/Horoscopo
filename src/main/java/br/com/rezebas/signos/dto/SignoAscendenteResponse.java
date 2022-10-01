package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignoAscendenteResponse {
    private String nome;
    @JsonProperty("signo_ascendente")
    private String signoAscendente;
}
