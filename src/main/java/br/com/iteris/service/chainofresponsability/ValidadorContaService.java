package br.com.iteris.service.chainofresponsability;

import java.util.List;

import br.com.iteris.domain.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidadorContaService {

    @Autowired
    private List<ValidadorConta> validadorContaList;

    public boolean contaPodeSerCriada(Conta conta) {
        for (ValidadorConta validadorconta : validadorContaList) {
            if (validadorconta.isContaValidada(conta)) {
                continue;
            }
            return false;
        }
        return true;
    }

}
