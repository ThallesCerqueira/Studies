package br.com.fiap.banco;

public class ContaPoupanca extends Conta {

    private String tipo;

    @Override
    public double getSaldo(){
        return saldo;
    }

}
