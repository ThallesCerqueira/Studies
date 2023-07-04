package pessoas;

import java.util.Objects;

public abstract class Pessoa {

    // Atributos da Classe
    private String nome;
    private String endereco;
    private double renda;

    // Construtor com apenas 2 parâmetros
    public Pessoa( String nome, double renda ) {
        this( nome, "", renda );
    }

    // Construtor com 3 parâmetros
    public Pessoa( String nome, String endereco, double renda ) {

        if( validaPessoa( nome, endereco, renda ) ) {
            this.nome = nome;
            this.endereco = endereco;
            this.renda = renda;
        } else {
            this.nome = "Sem identificação.";
            this.endereco = "Sem endereço";
            this.renda = 0.0d;
        }

    }

    // Método para verificar se os dados são válidos
    private boolean validaPessoa( String nome, String endereco, double renda ) {
        return !Objects.equals(nome, "") && !Objects.equals(endereco, "") && renda >= 0;
    }

    // Getters da Classe
    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public double getRenda() {
        return this.renda;
    }

    public long getKeyPessoa() {
        return 0;
    }
}