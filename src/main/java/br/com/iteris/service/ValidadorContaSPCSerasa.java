package br.com.iteris.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidadorContaSPCSerasa {

    /* Simulando consulta */
    public boolean consultaNomeSistemaSPSSerasa(String nome) {
        if (nome.contains("xpto")) {
            log.info("Usuário: {} está com nome sujo, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} está com nome limpo", nome);
            return true;
        }
    }

}
