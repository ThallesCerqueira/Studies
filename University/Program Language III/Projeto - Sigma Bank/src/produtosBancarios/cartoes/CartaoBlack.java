package produtosBancarios.cartoes;

import utils.Data;

public class CartaoBlack extends Cartao {

    private int milhas;

    public CartaoBlack( double limite, int senha ) {
        this( null, limite, senha );
    }

    public CartaoBlack(Data vencimento, double limite, int senha ) {
        super( vencimento, limite, senha );
        this.milhas = 0;
    }

    @Override
    public boolean comprarAlgo( double valor ) {
        if( super.comprarAlgo(valor) ) {
            setMilhas();
            return true;
        }

        return false;
    }

    @Override
    public boolean pagarFatura( double pagamento ) {
        if( super.pagarFatura( pagamento ) ) {
            setMilhas();
            return true;
        }

        return false;
    }

    private void setMilhas() {
        this.milhas += 30;
    }
}