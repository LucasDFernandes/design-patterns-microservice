package br.com.iteris.service.chainofresponsability;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import br.com.iteris.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidadorContaService {

    @Autowired
    private List<ValidadorConta> validadorContaList;

    public boolean contaPodeSerCriada(Conta conta) {
        AtomicBoolean isContavalida = new AtomicBoolean(true);
        validadorContaList
                .stream()
                .takeWhile(t -> isContavalida.get())
                .forEachOrdered(validadorConta -> isContavalida.set(validadorConta.isContaValidada(conta)));
        return isContavalida.get();
    }

}
