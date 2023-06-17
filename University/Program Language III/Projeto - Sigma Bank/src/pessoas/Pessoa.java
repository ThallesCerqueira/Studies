package pessoas;

public abstract class Pessoa {

    private String nome;
    private String endereco;
    private double renda;

    public Pessoa( String nome, double renda ) {
        this( nome, "", renda );
    }

    public Pessoa( String nome, String endereco, double renda ) {

        if( validaPessoa( nome, endereco, renda ) ) {
            this.nome = nome;
            this.endereco = endereco;
            this.renda = renda;
        } else {
            this.nome = "Sem identificação.";
            this.endereco = "Sem endereço.";
            this.renda = 0.0d;
        }

    }

    private boolean validaPessoa( String nome, String endereco, double renda ) {
        return !nome.equals("") && !endereco.equals("") && renda >= 0;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public double getRenda() {
        return this.renda;
    }
}