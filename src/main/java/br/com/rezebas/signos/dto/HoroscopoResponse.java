package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class HoroscopoResponse {
    private String nome;
    private Integer idade;
    @JsonProperty("data_nascimento")
    private String dataNascimento;
    @JsonProperty("ano_bisexto")
    private Boolean anoNascimentoBisexto;
    @JsonProperty("local_nascimento")
    private String localNasimento;
    @JsonProperty("time_zone")
    private String timeZoneNascimento;
    @JsonProperty("signo_solar")
    private String signoSolar;
    @JsonProperty("signo_ascendente")
    private String signoAscendente;
    @JsonProperty("signo_lunar")
    private String signoLunar;
}
