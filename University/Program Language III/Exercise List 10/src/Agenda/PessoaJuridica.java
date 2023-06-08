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
            this.faturamento = faturamento;
        }

    }

    private boolean validaPessoaJuridica( double faturamento ) {
        return faturamento >= 0;
    }

}
