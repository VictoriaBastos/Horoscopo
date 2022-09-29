package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HoroscopoRequest {

    @NotBlank(message = "Campo nome e obrigatorio.")
    private String nome;

    @Max(value = 4)
    @NotNull(message = "Campo ano de nascimento e obrigatorio.")
    @JsonProperty(value = "ano_nascimento")
    private Integer anoNascimento;

    @Max(value = 2)
    @NotNull(message = "Campo mes de nascimento e obrigatorio.")
    @JsonProperty(value = "mes_nascimento")
    private Integer mesNascimento;

    @Max(value = 2)
    @NotNull(message = "Campo dia de nascimento e obrigatorio.")
    @JsonProperty(value = "dia_nascimento")
    private Integer diaNascimento;

    @NotBlank(message = "Campo hora de nascimento e obrigatorio.")
    @JsonProperty(value = "hora_nascimento")
    private Integer horaNascimento;

    @NotBlank(message = "Campo minuto de nascimento e obrigatorio.")
    @JsonProperty(value = "minutos_nascimento")
    private Integer minutosNascimento;

    @NotBlank(message = "Campo local de nascimento e obrigatorio.")
    @JsonProperty(value = "local_nascimento")
    private String localNascimento;
}
