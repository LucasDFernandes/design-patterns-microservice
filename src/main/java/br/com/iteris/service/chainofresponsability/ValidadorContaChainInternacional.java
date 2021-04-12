package br.com.iteris.service.chainofresponsability;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(2)
public class ValidadorContaChainInternacional implements ValidadorConta {

    @Override
    public boolean isContaValidada(Conta conta) {
        log.info("Verificando nome no sistema do FBI ...");
        return consultaFBI(conta.getNome());
    }

    private boolean consultaFBI(String nome) {
        if (nome.equals("Pablo Escobar")) {
            log.info("Usuário: {} é procurado internacionalmente, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} não possui ficha criminal internacional", nome);
            return true;
        }
    }

}
