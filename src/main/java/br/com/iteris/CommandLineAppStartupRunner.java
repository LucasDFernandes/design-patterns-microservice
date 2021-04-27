package br.com.iteris;

import br.com.iteris.domain.Conta;
import br.com.iteris.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private ContaService contaService;

    @Override
    public void run(String... args) throws Exception {
        Conta c1 = new Conta("Aegon Targeryan", 5000);
        Conta c3 = new Conta("Fernandinho Beira-Mar", 5000);
        Conta c4 = new Conta("Pablo Escobar", 5000);
        Conta c5 = new Conta("xpto", 5000);
        Conta c2 = new Conta("Jaime Lannister", 5000);

        contaService.criarConta(c3);
        contaService.criarConta(c4);
        contaService.criarConta(c5);
//        contaService.criarConta(c1);
//        contaService.criarConta(c2);

        contaService.realizaSaque(c1, 2000);
        contaService.realizaDeposito(c2, 6000);
    }
}
