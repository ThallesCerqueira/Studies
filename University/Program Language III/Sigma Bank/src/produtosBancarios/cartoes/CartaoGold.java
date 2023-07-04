package produtosBancarios.cartoes;

import utils.Data;

public class CartaoGold extends Cartao {

    // Atributos da classe.
    private final double anuidade = 10.0d;

    // Construtor com 2 parâmetros
    public CartaoGold( double limite, int senha ) {
        this( null, limite, senha );
    }

    // Construtor com 3 parâmetros
    public CartaoGold(Data vencimento, double limite, int senha ) {
        super( vencimento, limite, senha );
    }

    // Sobreescrita do método ComprarAlgo
    @Override
    public boolean comprarAlgo( double valor, int senha ) {
        return super.comprarAlgo( valor + 4 + anuidade, senha );
    }

    // Sobreescrita do método toString
    @Override
    public String toString() {
        return super.toString() + ", Anuidade: " + this.anuidade;
    }

}