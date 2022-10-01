package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignoSolarResponse {
    private String nome;
    @JsonProperty("signo_solar")
    private String signoSolar;
}
