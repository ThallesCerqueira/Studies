package produtosBancarios.contas;

import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;

public class ContaCorrente extends Conta {

    public ContaCorrente( String nome, long key, String endereco ,double renda, int tipo ) {

        super();

        // Escolhendo se será Pessoa Física ou Jurídica
        if( tipo == 1 ) {
            setConta( new PessoaFisica( nome, key, endereco,renda ));
        } else if ( tipo == 2 ) {
            setConta( new PessoaJuridica( nome, key, endereco,renda ));
        }

    }

}
