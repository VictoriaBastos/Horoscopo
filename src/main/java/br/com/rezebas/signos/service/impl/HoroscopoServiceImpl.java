package br.com.rezebas.signos.service.impl;

import br.com.rezebas.signos.dto.*;
import br.com.rezebas.signos.enums.*;
import br.com.rezebas.signos.factory.SignoInfoFactory;
import br.com.rezebas.signos.model.Signo;
import br.com.rezebas.signos.service.HoroscopoService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class HoroscopoServiceImpl implements HoroscopoService {

    private final SignoInfoFactory factory;

    public HoroscopoServiceImpl(SignoInfoFactory factory) {
        this.factory = factory;
    }

    @Override
    public MapaAstralResponse getMapaAstral(MapaAstralRequest request) {

        LocalDateTime dataNascimento = request.getDataHoraNascimento();

        LocalTime horaNascimento = request.getDataHoraNascimento().toLocalTime();
        String signoSolar = findSignoSolar(MonthDay.from(dataNascimento));

        return MapaAstralResponse.builder()
                .nome(request.getNome())
                .idade(getIdade(dataNascimento))
                .dataNascimento(getDataFormatada(dataNascimento))
                .anoNascimentoBisexto(isAnoBisexto(dataNascimento.getYear()))
                .localNasimento(request.getLocalNascimento())
                .timeZoneNascimento(getTimeZoneNascimento(dataNascimento, request.getLocalNascimento()))
                .signoSolar(signoSolar)
                .signoAscendente(findSignoAscendente(signoSolar,horaNascimento))
                .signoLunar(findSignoLunar(request.getLocalNascimento(), horaNascimento))
                .build();
    }

    @Override
    public SignoSolarResponse getSignoSolar(MapaAstralRequest request) {
        MonthDay diaMesNascimento = MonthDay.from(request.getDataHoraNascimento());
        String signo = findSignoSolar(diaMesNascimento);

        return SignoSolarResponse.builder().nome(request.getNome()).signoSolar(signo).build();
    }

    @Override
    public SignoAscendenteResponse getSignoAscendente(MapaAstralRequest request) {
        MonthDay diaMesNascimento = MonthDay.from(request.getDataHoraNascimento());
        String signo = findSignoSolar(diaMesNascimento);
        String ascendente = findSignoAscendente(signo,request.getDataHoraNascimento().toLocalTime());

        return SignoAscendenteResponse.builder().nome(request.getNome()).signoAscendente(ascendente).build();
    }

    @Override
    public SignoLunarResponse getSignoLunar(MapaAstralRequest request) {
        LocalTime horaNascimento = request.getDataHoraNascimento().toLocalTime();
        String signoLunar = findSignoLunar(request.getLocalNascimento(),horaNascimento);
        return SignoLunarResponse.builder().nome(request.getNome()).signoLunar(signoLunar).build();
    }

    private String findSignoSolar(MonthDay diaMesNascimento) {
        for(SignoSolar signo : SignoSolar.values()){
            if(diaMesNascimento.isAfter(signo.getStartDate()) && diaMesNascimento.isBefore(signo.getEndDate())){
                return signo.getSignoNome();
            }
        }
        return "Dados incorretos, signo nao localizado.";
    }

    private String findSignoAscendente(String signoSolar, LocalTime horaNascimento){

        Signo signoInformation = factory.getSignoInfo(signoSolar);
        return signoInformation.findAscendente(signoSolar,horaNascimento);
    }

    private String findSignoLunar(String localNascimento, LocalTime horaNascimento){
        if("recife".equalsIgnoreCase(localNascimento) && horaNascimento.isAfter(LocalTime.NOON)) return "Casimiro";
        if("cuiaba".equalsIgnoreCase(localNascimento) && horaNascimento.isBefore(LocalTime.NOON)) return "Odin";
        if("sao paulo".equalsIgnoreCase(localNascimento)) return "Gandalf";
        return "Em construcao";
    }

    private Integer getIdade(LocalDateTime data) {
        LocalDate dataNascimento = LocalDate.of(data.getYear(),data.getMonth(),data.getDayOfMonth());
        Period period = Period.between(dataNascimento, LocalDate.now());
        return period.getYears();
    }

    private String getDataFormatada(LocalDateTime dataNascimento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        return formatter.format(dataNascimento);
    }

    private Boolean isAnoBisexto(Integer year) {
        Year leapYear = Year.of(year);
        return leapYear.isLeap();
    }

    private String getTimeZoneNascimento(LocalDateTime dataNascimento, String localNascimento) {
        String zone = getZoneId(localNascimento);
        ZonedDateTime zoneInfo = ZonedDateTime.of(dataNascimento, ZoneId.of(zone));
        return zone + " " + zoneInfo.getOffset().toString();
    }

    private static String getZoneId(String local){
        Set<String> zonesId = ZoneId.getAvailableZoneIds();
        for( String zoneId : zonesId){
            if (zoneId.contains(local)) return zoneId;
        }
        return "America/Sao_Paulo";
    }
}