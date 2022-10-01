package br.com.rezebas.signos.service;

import br.com.rezebas.signos.dto.*;

public interface HoroscopoService {

    SignoSolarResponse getSignoSolar(MapaAstralRequest request);

    SignoAscendenteResponse getSignoAscendente(MapaAstralRequest request);


    SignoLunarResponse getSignoLunar(MapaAstralRequest request);

    MapaAstralResponse getMapaAstral(MapaAstralRequest request);
}
