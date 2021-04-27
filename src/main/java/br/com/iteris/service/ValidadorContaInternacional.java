package br.com.iteris.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidadorContaInternacional {

    /* Simulando consulta */
    public boolean consultaFBI(String nome) {
        if (nome.equals("Pablo Escobar")) {
            log.info("Usuário: {} é procurado internacionalmente, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} não possui ficha criminal internacional", nome);
            return true;
        }
    }

}
