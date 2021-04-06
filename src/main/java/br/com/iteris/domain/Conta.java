package br.com.iteris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conta {

    private String nome;
    private double saldo;

    public double saca(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return valor;
        }
        // Exception Genérica
        throw new RuntimeException("");
    }

    public void deposita(double valor) {
        saldo += valor;
    }
}
