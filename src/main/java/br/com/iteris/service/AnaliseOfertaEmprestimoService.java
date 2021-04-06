package br.com.iteris.service;

import br.com.iteris.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnaliseOfertaEmprestimoService {

    public void analisaOfertaEmprestimo(Conta conta) {
        log.info("Conta: {}, Enviar notificação de análise de perfil para oferta de empréstimo", conta.getNome());
    }
}
