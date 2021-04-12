package br.com.iteris.service;

import java.util.List;

import br.com.iteris.domain.Conta;
import br.com.iteris.service.chainofresponsability.ValidadorContaService;
import br.com.iteris.service.observer.AcaoAposAlteracaoSaldo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContaService {

    @Autowired
    private List<AcaoAposAlteracaoSaldo> listaAcoes;

    @Autowired
    private ValidadorContaService validadorContaService;

    public Conta criarConta(Conta conta) {
        if (validadorContaService.contaPodeSerCriada(conta)) {
            // persiste informação em base de dados
            log.info("Conta: {} criada com sucesso", conta);
            return conta;
        }

        log.warn("Conta não pode ser criada pois apresentada problema com orgãos públicos");
        return null;
    }

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
