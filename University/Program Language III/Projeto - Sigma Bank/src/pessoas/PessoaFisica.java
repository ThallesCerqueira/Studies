package pessoas;

import utils.Data;
import java.util.Random;

public class PessoaFisica extends Pessoa {

    private long cpf;
    private Data nascimento;

    public PessoaFisica( String nome, long cpf, double renda ) {
        this( nome, cpf, null, "", renda );
    }

    public PessoaFisica( String nome, long cpf, Data nascimento, String endereco, double renda ) {

        super(nome, endereco, renda );

        if( validaPessoaFisica( cpf, nascimento ) ) {

            this.cpf = cpf;
            this.nascimento = nascimento;

        } else {

            Random rand = new Random();
            this.cpf = rand.nextInt( 1000, 999999999 );
            this.nascimento = new Data();

        }

    }

    private boolean validaPessoaFisica( long cpf, Data nascimento ) {
        return cpf >= 1000 && nascimento != null;
    }

    public long getCpf() {
        return this.cpf;
    }

    public Data getNascimento() {
        return this.nascimento;
    }
}