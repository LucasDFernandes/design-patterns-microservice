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
        Conta aegonTargeryan = new Conta("Aegon Targeryan", 5000);
        Conta jaimeLannister = new Conta("Jaime Lannister", 5000);

        contaService.realizaSaque(aegonTargeryan, 2000);
        contaService.realizaDeposito(jaimeLannister, 6000);
    }
}
