package br.com.iteris.service.chainofresponsability;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(3)
public class ValidadoChain implements ValidadorConta {

    @Override
    public boolean isContaValidada(Conta conta) {
        log.info("Usuário pode ter a conta criada");
        return true;
    }

}
