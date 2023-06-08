public class RoboSimples {

    private  String nomeDoRobo;
    private int posicaoXAtual,posicaoYAtual;
    private char direcaoAtual;

    public RoboSimples(String nome, int px, int py, char d){
        nomeDoRobo = nome;
        posicaoXAtual = px;
        posicaoYAtual = py;
        direcaoAtual = d;
    }

    public RoboSimples(String nome){
        this(nome, 0, 0, 'N');
    }

    public RoboSimples(){
        this("Wally");
    }

    public void move() {
        this.move(1);
    }

    public void move( int passos ){
        if (direcaoAtual == 'N') posicaoYAtual += passos;
        if (direcaoAtual == 'S') posicaoYAtual -= passos;
        if (direcaoAtual == 'E') posicaoXAtual += passos;
        if (direcaoAtual == 'O') posicaoXAtual -= passos;
    }

    public void mudaDireção( char novaDirecao ){

        direcaoAtual = novaDirecao;
    }

    public String toString(){
        String str = "\nNome do robo: "+nomeDoRobo+"\n";
        str = str + "Posicao do robo: ("+posicaoXAtual+", "+posicaoYAtual+")\n";
        str = str + "Direcao do robo: "+direcaoAtual;

        return str;
    }

    public boolean validaRobo() {

        if( this.nomeDoRobo == null || ( this.direcaoAtual != 'N' && this.direcaoAtual != 'S' && this.direcaoAtual != 'E' && this.direcaoAtual != 'O') )
        {
            return false;
        }

        return true;

    }

}
