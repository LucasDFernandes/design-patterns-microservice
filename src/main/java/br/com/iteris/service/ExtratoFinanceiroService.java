package br.com.iteris.service;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExtratoFinanceiroService implements AcaoAposAlteracaoSaldo {

    @Override
    public void executaAcao(Conta conta) {
        log.info("Conta: {} possui o saldo atual de: {}", conta.getNome(), conta.getSaldo());
    }
}
