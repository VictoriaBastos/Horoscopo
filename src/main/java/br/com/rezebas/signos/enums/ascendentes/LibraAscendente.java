package br.com.rezebas.signos.enums.ascendentes;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public enum LibraAscendente {

    ARIES (LocalTime.of(10,31),LocalTime.of(12,30), "Aries"),
    TOURO (LocalTime.of(12,31),LocalTime.of(14,30), "Touro"),
    GEMEOS (LocalTime.of(14,31),LocalTime.of(16,30), "Gemeos"),
    CANCER (LocalTime.of(16,31),LocalTime.of(18,30), "Cancer"),
    LEAO (LocalTime.of(18,31),LocalTime.of(20,30), "Leao"),
    VIRGEM (LocalTime.of(20,31),LocalTime.of(22,30), "Virgem"),
    LIBRA (LocalTime.of(22,31),LocalTime.of(0,30), "Libra"),
    ESCORPIAO (LocalTime.of(0,31),LocalTime.of(2,30), "Escorpiao"),
    SAGITARIO (LocalTime.of(2,31),LocalTime.of(4,30), "Sagitario"),
    CAPRICORNIO (LocalTime.of(4,31),LocalTime.of(6,30), "Capricornio"),
    AQUARIO (LocalTime.of(6,31),LocalTime.of(8,30), "Aquario"),
    PEIXES (LocalTime.of(8,31),LocalTime.of(10,30), "Peixes");

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String ascendente;

    LibraAscendente(LocalTime startTime, LocalTime endTime, String ascendente) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.ascendente = ascendente;
    }
}
