package Pessoas;

public class Prefeito extends Politico {

    private String cidade;

    public Prefeito( String nome, long id, Data nascimento, String sigla, int numeroPartido, String cidade ) {
        super( nome, id, nascimento, sigla, numeroPartido );

        if( validaPrefeito( cidade ) ) {
            this.cidade = cidade;
        } else {
            this.cidade = "Cidade desconhecida.";
        }
    }

    private boolean validaPrefeito(String cidade) {
        return cidade != "";
    }

    @Override
    public String toString() {
        return super.toString() + ", Cidade: " + this.cidade;
    }

}
