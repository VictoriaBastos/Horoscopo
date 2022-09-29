package br.com.rezebas.signos.factory;

import br.com.rezebas.signos.model.Aquario;
import br.com.rezebas.signos.model.Aries;
import br.com.rezebas.signos.model.Signo;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SignoInfoFactory {

    private final Map<String, Signo> signoInfo = Map.of(
      "Aries", new Aries(),
      "Aquario", new Aquario()
    );

    public Signo getSignoInfo(String signoSolar){
        return signoInfo.get(signoSolar);
    }
}
