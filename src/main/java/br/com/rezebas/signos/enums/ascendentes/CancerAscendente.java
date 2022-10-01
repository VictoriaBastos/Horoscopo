package br.com.rezebas.signos.enums.ascendentes;

import lombok.Getter;

import java.time.LocalTime;
@Getter
public enum CancerAscendente {

    ARIES (LocalTime.of(22,31),LocalTime.of(0,30), "Aries"),
    TOURO (LocalTime.of(0,31),LocalTime.of(2,30), "Touro"),
    GEMEOS (LocalTime.of(2,31),LocalTime.of(4,30), "Gemeos"),
    CANCER (LocalTime.of(4,31),LocalTime.of(6,30), "Cancer"),
    LEAO (LocalTime.of(6,31),LocalTime.of(8,30), "Leao"),
    VIRGEM (LocalTime.of(8,31),LocalTime.of(10,30), "Virgem"),
    LIBRA (LocalTime.of(10,31),LocalTime.of(12,30), "Libra"),
    ESCORPIAO (LocalTime.of(12,31),LocalTime.of(14,30), "Escorpiao"),
    SAGITARIO (LocalTime.of(14,31),LocalTime.of(16,30), "Sagitario"),
    CAPRICORNIO (LocalTime.of(16,31),LocalTime.of(18,30), "Capricornio"),
    AQUARIO (LocalTime.of(18,31),LocalTime.of(20,30), "Aquario"),
    PEIXES (LocalTime.of(20,31),LocalTime.of(22,30), "Peixes");

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String ascendente;

    CancerAscendente(LocalTime startTime, LocalTime endTime, String ascendente) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.ascendente = ascendente;
    }
}
