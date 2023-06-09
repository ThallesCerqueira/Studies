package Agenda;
import Pessoas.Data;

public class PessoaFisica extends Pessoa {

    private long cpf;
    private Data aniversario;

    public PessoaFisica( String nome, long cpf, String endereco, Data aniversario, long telefone, String email ) {

        super( nome, endereco, telefone, email );
        this.cpf = cpf;

        if( validaPessoaFisica( aniversario ) ) {
            this.aniversario = aniversario;
        } else {
            this.aniversario = new Data();
        }

    }

    private boolean validaPessoaFisica( Data aniversario ) {
        return aniversario != null;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cpf: " + this.cpf + ", Aniversário: " + this.aniversario.toString();
    }

    @Override
    public long getChave() {
        return this.cpf;
    }

}