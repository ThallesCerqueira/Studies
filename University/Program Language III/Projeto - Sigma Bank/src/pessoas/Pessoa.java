package pessoas;

import gerais.Data;

public class Pessoa {

    private String nome;
    private long cpf;
    private Data nascimento;
    private String endereco;
    private double renda;

    public Pessoa( String nome, long cpf, Data nascimento, String endereco, double renda ) {

        if( validaPessoa( nome, cpf, nascimento, endereco, renda ) ) {
            this.nome = nome;
            this.cpf = cpf;
            this.nascimento = nascimento;
            this.endereco = endereco;
            this.renda = renda;
        } else {
            this.nome = "Sem identificação.";
            this.cpf = 0;
            this.nascimento = new Data();
            this.endereco = "Sem endereço.";
            this.renda = 0.0d;
        }


    }

    private boolean validaPessoa( String nome, long cpf, Data nascimento, String endereco, double renda ) {
        return !nome.equals("") && cpf >= 0 && nascimento != null && !endereco.equals("") && renda >= 0;
    }



}
