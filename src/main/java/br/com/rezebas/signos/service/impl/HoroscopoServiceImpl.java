package br.com.rezebas.signos.service.impl;

import br.com.rezebas.signos.dto.HoroscopoRequest;
import br.com.rezebas.signos.dto.HoroscopoResponse;
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

    private final SignoInfoFactory signoFactory;

    public HoroscopoServiceImpl(SignoInfoFactory signoFactory) {
        this.signoFactory = signoFactory;
    }

    @Override
    public HoroscopoResponse getMapaAstral(HoroscopoRequest request) {

        LocalDateTime dataNascimento = LocalDateTime.of(request.getAnoNascimento(), request.getMesNascimento(),
                request.getDiaNascimento(),request.getHoraNascimento(),request.getMinutosNascimento());
        LocalTime horaNascimento = LocalTime.of(request.getHoraNascimento(), request.getMinutosNascimento());
        String signoSolar = findSignoSolar(MonthDay.of(request.getMesNascimento(), request.getDiaNascimento()));

        return HoroscopoResponse.builder()
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
    public HoroscopoResponse getSignoSolar(HoroscopoRequest request) {
        MonthDay diaMesNascimento = MonthDay.of(request.getMesNascimento(), request.getDiaNascimento());
        String signo = findSignoSolar(diaMesNascimento);

        return HoroscopoResponse.builder().nome(request.getNome()).signoSolar(signo).build();
    }

    @Override
    public HoroscopoResponse getSignoAscendente(HoroscopoRequest request) {
        MonthDay diaMesNascimento = MonthDay.of(request.getMesNascimento(), request.getDiaNascimento());
        String signo = findSignoSolar(diaMesNascimento);
        String ascendente = findSignoAscendente(signo,LocalTime.of(request.getHoraNascimento(), request.getMinutosNascimento()));

        return HoroscopoResponse.builder().nome(request.getNome()).signoAscendente(ascendente).build();
    }

    @Override
    public HoroscopoResponse getSignoLunar(HoroscopoRequest request) {
        return null;
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
        Signo signoInfo = signoFactory.getSignoInfo(signoSolar);
        return signoInfo.findAscendente(signoSolar, horaNascimento);
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