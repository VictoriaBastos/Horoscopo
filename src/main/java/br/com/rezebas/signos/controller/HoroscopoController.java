package br.com.rezebas.signos.controller;

import br.com.rezebas.signos.dto.HoroscopoRequest;
import br.com.rezebas.signos.dto.HoroscopoResponse;
import br.com.rezebas.signos.service.HoroscopoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/horoscopo")
public class HoroscopoController {

    private final HoroscopoService service;

    public HoroscopoController(HoroscopoService service) {
        this.service = service;
    }


    @GetMapping("/mapaAstral")
    public ResponseEntity<HoroscopoResponse> getMapaAstral(@Valid @RequestBody HoroscopoRequest request){
        return ResponseEntity.ok(service.getMapaAstral(request));
    }

    @GetMapping("/signoSolar")
    public ResponseEntity<HoroscopoResponse> getSignoSolar(@Valid @RequestBody HoroscopoRequest request){
        return ResponseEntity.ok(service.getSignoSolar(request));
    }

    @GetMapping("/signoAscendente")
    public ResponseEntity<HoroscopoResponse> getSignoAscendente(@RequestBody HoroscopoRequest request){
        return ResponseEntity.ok(service.getSignoAscendente(request));
    }

    @GetMapping("/signoLunar")
    public ResponseEntity<HoroscopoResponse> getSignoLunar(@RequestBody HoroscopoRequest request){
        return ResponseEntity.ok(service.getSignoLunar(request));
    }
}
