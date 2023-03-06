package br.com.fiap.banco.teste;

import br.com.fiap.banco.Conta;

public class Teste {

    public static void main(String[] args) {

        Conta cc = new Conta();

        System.out.println("Valor padrão da conta CC: " + cc.getSaldo() );

        cc.depositar(1000);

        Conta cc2 = new Conta( 100, 0070, 1000 );
        System.out.println("Valor padrão da conta CC2: " + cc2.getSaldo() );

    }

}
