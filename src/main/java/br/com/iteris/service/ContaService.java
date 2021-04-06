package br.com.iteris.service;

import java.util.List;

import br.com.iteris.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private List<AcaoAposAlteracaoSaldo> listaAcoes;

    public double realizaSaque(Conta conta, double valor) {
        double saque = conta.saca(valor);
        listaAcoes.forEach(acaoAposAlteracaoSaldo -> acaoAposAlteracaoSaldo.executaAcao(conta));
        return saque;
    }

    public void realizaDeposito(Conta conta, double valor) {
        conta.deposita(valor);
        listaAcoes.forEach(acaoAposAlteracaoSaldo -> acaoAposAlteracaoSaldo.executaAcao(conta));
    }


}
