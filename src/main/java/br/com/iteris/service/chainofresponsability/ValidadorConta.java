package br.com.iteris.service.chainofresponsability;

import br.com.iteris.domain.Conta;

public interface ValidadorConta {

    boolean isContaValidada(Conta conta);

}
