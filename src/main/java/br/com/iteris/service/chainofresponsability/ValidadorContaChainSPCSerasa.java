package br.com.iteris.service.chainofresponsability;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(0)
public class ValidadorContaChainSPCSerasa implements ValidadorConta {

    @Override
    public boolean isContaValidada(Conta conta) {
        log.info("Verificando conta no sistema SPC/Serasa ...");
        return consultaNomeSistemaSPSSerasa(conta.getNome());
    }

    /* Simulando consulta */
    private boolean consultaNomeSistemaSPSSerasa(String nome) {
        if (nome.contains("xpto")) {
            log.info("Usuário: {} está com nome sujo, bloquear criação de conta", nome);
            return false;
        } else {
            log.info("Usuário: {} está com nome limpo", nome);
            return true;
        }
    }

}
