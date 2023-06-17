package pessoas;

import utils.Data;
import java.util.Random;

public class PessoaJuridica extends Pessoa {

    private long cnpj;
    private Data dataAbertura;

    public PessoaJuridica( String nome, long cnpj, double renda ) {
        this( nome, cnpj, null, "", renda );
    }

    public PessoaJuridica( String nome, long cnpj, Data dataAbertura, String endereco, double renda ) {
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

    private boolean validaPessoaJuridica( long cnpj, Data dataAbertura ) {
        return cnpj >= 1000 && dataAbertura != null;
    }

    public long getCnpj() {
        return this.cnpj;
    }

    public Data getDataAbertura() {
        return this.dataAbertura;
    }
}
