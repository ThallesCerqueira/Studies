package produtosBancarios.cartoes;

import utils.Data;

public class CartaoBlack extends Cartao {

    // Atributos da Classe
    private int milhas;

    // Construtor com 2 parâmetros
    public CartaoBlack( double limite, int senha ) {
        this( null, limite, senha );
    }

    // Construtor com 3 parâmetros
    public CartaoBlack(Data vencimento, double limite, int senha ) {

        // Chamando construtor da Super Class
        super( vencimento, limite, senha );
        this.milhas = 0;
    }

    // Sobreescrita do método comprarAlgo
    @Override
    public boolean comprarAlgo( double valor, int senha ) {
        if( super.comprarAlgo( valor, senha ) ) {
            setMilhas();
            return true;
        }

        return false;
    }

    // Sobreescrita do método pagar
    @Override
    public boolean pagar( double pagamento ) {
        if( super.pagar( pagamento ) ) {
            setMilhas();
            return true;
        }

        return false;
    }

    // Sobreescrita do método toString
    @Override
    public String toString() {
        return super.toString() + ", Milhas: " + this.milhas;
    }

    // Método para atribuir milhas, quando o cliente Compra ou paga a fatura.
    private void setMilhas() {
        this.milhas += 30;
    }
}