package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignoLunarResponse {
    private String nome;
    @JsonProperty("signo_lunar")
    private String signoLunar;
}
