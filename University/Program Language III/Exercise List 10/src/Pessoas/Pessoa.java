package Pessoas;

public class Pessoa {

    private String nome;
    private long id;
    private Data nascimento;

    public Pessoa( String nome, long id, Data nascimento ) {
        if ( validaPessoa( nome, id, nascimento ) ) {
            this.nome = nome;
            this.id = id;
            this.nascimento = nascimento;
        }else{
            this.nome = "João Padrão";
            this.id = 0L;
            this.nascimento = new Data( 1, 1, 1970 );
        }
    }

    private boolean validaPessoa(String nome, long id, Data nascimento) {
        return nome != "" && id >= 0 && nascimento != null;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + ", Id: " + this.id + ", Nascimento: " + this.nascimento.toString();
    }

    public double calculaEmprestimo() {
        return 1000d;
    }

}
