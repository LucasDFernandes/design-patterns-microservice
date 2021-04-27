package br.com.iteris.service;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContaService {

    @Autowired
    private AnaliseOfertaEmprestimoService analiseOfertaEmprestimoService;

    @Autowired
    private AnaliseOfertaCartaoDeCreditoService analiseOfertaCartaoDeCreditoService;

    @Autowired
    private ValidadorContaSPCSerasa validadorContaSPCSerasa;

    @Autowired
    private ValidadorContaPoliciaFederal validadorContaPoliciaFederal;

    @Autowired
    private ValidadorContaInternacional validadorContaInternacional;

    public Conta criarConta(Conta conta) {
        if (contaPodeSerCriada(conta)) {
            // persiste informação em base de dados
            log.info("Conta: {} criada com sucesso", conta);
            return conta;
        }

        log.warn("Conta não pode ser criada pois apresentada problema com orgãos públicos");
        return null;
    }

    private boolean contaPodeSerCriada(Conta conta) {
        if (!validadorContaSPCSerasa.consultaNomeSistemaSPSSerasa(conta.getNome())) {
            return false;
        } else if (!validadorContaPoliciaFederal.consultaAntecedentesCriminais(conta.getNome())) {
            return false;
        } else {
            return validadorContaInternacional.consultaFBI(conta.getNome());
        }
    }

    public double realizaSaque(Conta conta, double valor) {
        double saque = conta.saca(valor);
        analiseOfertaEmprestimoService.analisaOfertaEmprestimo(conta);
        analiseOfertaCartaoDeCreditoService.analisaOfertaCartaoDeCredito(conta);
        return saque;
    }

    public void realizaDeposito(Conta conta, double valor) {
        conta.deposita(valor);
        analiseOfertaEmprestimoService.analisaOfertaEmprestimo(conta);
        analiseOfertaCartaoDeCreditoService.analisaOfertaCartaoDeCredito(conta);
    }

}
