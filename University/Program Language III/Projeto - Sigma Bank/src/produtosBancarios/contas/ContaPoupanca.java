package produtosBancarios.contas;

import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;
import utils.Data;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String nome, long key, Data data, String endereco, double renda, int tipo ) {

        super();
        // Escolhendo se será Pessoa Física ou Jurídica
        if( tipo == 1 ) {
            setConta( new PessoaFisica( nome, key, data, endereco, renda ));
        } else if ( tipo == 2 ) {
            setConta( new PessoaJuridica( nome, key, data, endereco,renda ));
        }

    }

}