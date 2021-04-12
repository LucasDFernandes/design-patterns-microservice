package br.com.iteris.service.observer;

import br.com.iteris.domain.Conta;

public interface AcaoAposAlteracaoSaldo {

    void executaAcao(Conta conta);
}
