package produtosBancarios.cartoes;

import utils.Data;

public class Cartao {

    private Data vencimento;
    private Data validade;
    private double limite;
    private final double anuidade = 0d;
    private double fatura;
    private long numCartao;
    private int senha;

    public Cartao( Data vencimento, double limite, int senha ) {

        if( validaCartao( vencimento, limite) ) {
            this.vencimento = vencimento;
            this.limite = limite;
        } else {
            this.vencimento = new Data(1, 1);
            this.limite = 0.0d;
        }

        this.senha = senha;
        this.validade = new Data( 2025 );
    }

    public Cartao( double limite, int senha ) {
        this( null, limite, senha );
    }

    private boolean validaCartao( Data vencimento, double limite ) {
        return vencimento != null && limite >= 0;
    }

    public boolean pagarFatura( double pagamento ) {

        if( this.fatura >= pagamento ) {
            this.fatura -= pagamento;
            return true;
        }

        return false;

    }

    public boolean comprarAlgo( double valor ) {

        if( this.limite >= valor ) {
            this.limite -= valor;
            this.fatura += valor;
            return true;
        }

        return false;
    }

    public double consultarLimite() {
        return this.limite;
    }

}