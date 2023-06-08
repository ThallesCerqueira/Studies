package Pessoas;

public class Politico extends Pessoa {

    private String sigla;
    private int numeroPartido;

    public Politico( String nome, long id, Data nascimento, String sigla, int numeroPartido ) {
        super( nome, id, nascimento );

        if( validaPolitico( sigla, numeroPartido ) ) {
            this.sigla = sigla;
            this.numeroPartido = numeroPartido;
        } else {
            this.sigla = "Sem partido";
            this.numeroPartido = 0;
        }
    }

    private boolean validaPolitico(String sigla, int numeroPartido) {
        return sigla != "" && numeroPartido >= 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sigla: " + this.sigla + ", Número Partido: " + this.numeroPartido;
    }

}
