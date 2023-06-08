package Pessoas;

public class Governador extends Politico {

    private String estado;

    public Governador( String nome, long id, Data nascimento, String sigla, int numeroPartido, String estado ) {
        super( nome, id, nascimento, sigla, numeroPartido );

        if( validaGovernador( estado ) ) {
            this.estado = estado;
        } else {
            this.estado = "estado desconhecida.";
        }
    }

    private boolean validaGovernador(String estado) {
        return estado != "";
    }

    @Override
    public String toString() {
        return super.toString() + ", Estado: " + this.estado;
    }

}