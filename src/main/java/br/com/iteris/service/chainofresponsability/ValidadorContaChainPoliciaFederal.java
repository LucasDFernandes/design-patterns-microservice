package br.com.iteris.service.chainofresponsability;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class ValidadorContaChainPoliciaFederal implements ValidadorConta {

    @Override
    public boolean isContaValidada(Conta conta) {
        log.info("Verificando nome no sistema da Polícia Federal ...");
        return consultaAntecedentesCriminais(conta.getNome());
    }

    private boolean consultaAntecedentesCriminais(String nome) {
        if (nome.equals("Fernandinho Beira-Mar")) {
            log.info("Usuário: {} possui antecedentes criminais, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} não possui ficha criminal", nome);
            return true;
        }
    }

}
