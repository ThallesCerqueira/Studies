package Agenda;

public class PessoaJuridica extends Pessoa {

    private long cnpj;
    private double faturamento;

    public PessoaJuridica( String nome, long cnpj, String endereco, double faturamento, long telefone, String email ) {

        super( nome, endereco, telefone, email );
        this.cnpj = cnpj;

        if( validaPessoaJuridica( faturamento ) ) {
            this.faturamento = faturamento;
        } else {
            this.faturamento = 0;
        }

    }

    private boolean validaPessoaJuridica( double faturamento ) {
        return faturamento >= 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cnpj: " + this.cnpj + ", Faturamento: " + this.faturamento;
    }

    @Override
    public long getChave() {
        return this.cnpj;
    }

}