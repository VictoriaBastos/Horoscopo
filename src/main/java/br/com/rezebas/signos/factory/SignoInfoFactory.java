package br.com.rezebas.signos.factory;

import br.com.rezebas.signos.model.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SignoInfoFactory {

    private Map<String, Signo> signoMap;

    public SignoInfoFactory(){
        signoMap = new HashMap<>();
        signoMap.put("Aries", new Aries());
        signoMap.put("Touro", new Touro());
        signoMap.put("Gemeos", new Gemeos());
        signoMap.put("Cancer", new Cancer());
        signoMap.put("Leao", new Leao());
        signoMap.put("Virgem", new Virgem());
        signoMap.put("Libra", new Libra());
        signoMap.put("Escorpiao", new Escorpiao());
        signoMap.put("Sagitario", new Sagitario());
        signoMap.put("Peixes", new Peixes());
        signoMap.put("Capricornio",new Capricornio());
        signoMap.put("Aquario",new Aquario());
    }


    public Signo getSignoInfo(String signoSolar) {
        return signoMap.get(signoSolar);
    }
}