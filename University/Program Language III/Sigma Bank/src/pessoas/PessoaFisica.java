package pessoas;

import utils.Data;
import java.util.Random;

public class PessoaFisica extends Pessoa {

    // Atributos da classe
    private long cpf;
    private Data nascimento;

    // Construtor com 4 parâmetros
    public PessoaFisica( String nome, long key, String endereco ,double renda ) {
        this( nome, key, new Data(), endereco, renda );
    }

    // Construtor com 5 parâmetros
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

    // Método para validar dados de entrada
    private boolean validaPessoaFisica( long cpf, Data nascimento ) {
        return cpf >= 1000 && nascimento != null;
    }

    // Sobreescrita e implementação do método getKeyPessoa
    @Override
    public long getKeyPessoa() {
        return this.cpf;
    }

    // Sobreescrita do método toString
    @Override
    public String toString() {
        return "Nome: " +super.getNome() +", Cpf: "+ this.cpf + ", Nascimento: " + nascimento.toString() + ", Endereço: " + super.getEndereco() + ", Renda: " +super.getRenda();
    }

}