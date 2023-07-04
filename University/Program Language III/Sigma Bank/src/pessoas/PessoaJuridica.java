package pessoas;

import utils.Data;
import java.util.Random;

public class PessoaJuridica extends Pessoa {

    // Atributos da Classe
    private long cnpj;
    private Data dataAbertura;

    // Construtor com 4 parâmetros
    public PessoaJuridica( String nome, long key, String endereco, double renda ) {
        this( nome, key, new Data(), endereco, renda );
    }

    // Construtor com 5 parâmetros
    public PessoaJuridica( String nome, long cnpj, Data dataAbertura, String endereco, double renda ) {

        // Chamando construtor da Super Class
        super( nome, endereco, renda );

        if( validaPessoaJuridica( cnpj, dataAbertura ) ) {
            this.cnpj = cnpj;
            this.dataAbertura = dataAbertura;
        } else {
            Random rand = new Random();
            this.cnpj = rand.nextLong( 1000, 999999999 );
            this.dataAbertura = new Data();
        }
    }

    // Método para verificar se os dados são válidos
    private boolean validaPessoaJuridica( long cnpj, Data dataAbertura ) {
        return cnpj >= 1000 && dataAbertura != null;
    }

    // Método sobreescrito, toString
    @Override
    public String toString() {
        return "Nome: " + super.getNome() +", Cnpj: "+ this.cnpj + ", Abertura: " + dataAbertura.toString() + ", Endereço: " + super.getEndereco() + ", Renda: " +super.getRenda();
    }

    // Sobreescrita e implementação do método getKeyPessoa
    @Override
    public long getKeyPessoa() {
        return this.cnpj;
    }

}