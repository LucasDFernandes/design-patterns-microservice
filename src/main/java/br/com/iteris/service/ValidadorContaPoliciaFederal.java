package br.com.iteris.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidadorContaPoliciaFederal {

    /* Simulando consulta */
    public boolean consultaAntecedentesCriminais(String nome) {
        if (nome.equals("Fernandinho Beira-Mar")) {
            log.info("Usuário: {} possui antecedentes criminais, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} não possui ficha criminal", nome);
            return true;
        }
    }

}
