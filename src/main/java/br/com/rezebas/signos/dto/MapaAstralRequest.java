package br.com.rezebas.signos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class MapaAstralRequest {

    @NotBlank(message = "Obrigatorio preencher campo nome.")
    private String nome;

    @NotNull(message = "Obrigatorio preencher campo data e hora de nascimento.")
    @JsonProperty(value = "data_hora_nascimento")
    private LocalDateTime dataHoraNascimento;

    @NotBlank(message = "Obrigatorio preencher campo local de nascimento.")
    @JsonProperty(value = "local_nascimento")
    private String localNascimento;
}
