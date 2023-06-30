package produtosBancarios.contas;

import utils.Data;
import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;

public class ContaCorrente extends Conta {

    // Construtor com 6 parâmetros
    public ContaCorrente( String nome, long key, Data data, String endereco, double renda, int tipo ) {

        // Chamando Construtor da Super Class
        super();

        // Escolhendo se será Pessoa Física ou Jurídica
        if( tipo == 1 ) {

            setCliente( new PessoaFisica( nome, key, data, endereco,renda ));
        } else if ( tipo == 2 ) {

            setCliente( new PessoaJuridica( nome, key, data, endereco,renda ));
        }

    }

}