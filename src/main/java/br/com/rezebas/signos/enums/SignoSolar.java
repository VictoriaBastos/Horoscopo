package br.com.rezebas.signos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.MonthDay;

@Getter
@AllArgsConstructor
public enum SignoSolar {

    ARIES (MonthDay.of(3,21), MonthDay.of(4,20), "Aries"),
    TOURO (MonthDay.of(4,21), MonthDay.of(5,20), "Touro"),
    GEMEOS (MonthDay.of(5,21), MonthDay.of(6,20), "Gemeos"),
    CANCER (MonthDay.of(6,21), MonthDay.of(7,20), "Cancer"),
    LEAO (MonthDay.of(7,21), MonthDay.of(8,20), "Leao"),
    VIRGEM (MonthDay.of(8,21), MonthDay.of(9,20), "Virgem"),
    LIBRA (MonthDay.of(9,21), MonthDay.of(10,20), "Libra"),
    ESCORPIAO (MonthDay.of(10,21), MonthDay.of(11,20), "Escorpiao"),
    SAGITARIO (MonthDay.of(11,21), MonthDay.of(12,20), "Sagitario"),
    CAPRICORNIO (MonthDay.of(12,21), MonthDay.of(1,20), "Capricornio"),
    AQUARIO (MonthDay.of(1,21), MonthDay.of(2,20), "Aquario"),
    PEIXES (MonthDay.of(2,21), MonthDay.of(3,20), "Peixes");

    private final MonthDay startDate;
    private final MonthDay endDate;
    private final String signoNome;
}
