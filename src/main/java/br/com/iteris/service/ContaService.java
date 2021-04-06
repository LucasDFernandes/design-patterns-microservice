package br.com.iteris.service;

import br.com.iteris.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private AnaliseOfertaEmprestimoService analiseOfertaEmprestimoService;

    @Autowired
    private AnaliseOfertaCartaoDeCreditoService analiseOfertaCartaoDeCreditoService;

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
