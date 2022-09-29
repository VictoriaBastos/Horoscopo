package br.com.rezebas.signos.service;

import br.com.rezebas.signos.dto.HoroscopoRequest;
import br.com.rezebas.signos.dto.HoroscopoResponse;

public interface HoroscopoService {

    HoroscopoResponse getSignoSolar(HoroscopoRequest request);

    HoroscopoResponse getSignoAscendente(HoroscopoRequest request);


    HoroscopoResponse getSignoLunar(HoroscopoRequest request);

    HoroscopoResponse getMapaAstral(HoroscopoRequest request);
}
