package produtosBancarios.cartoes;

import utils.Data;
import utils.Gerais;

public class Cartao implements Gerais {

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

    @Override
    public boolean pagar( double pagamento ) {

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

    @Override
    public double getSaldo() {
        return this.limite;
    }

    @Override
    public String toString() {
        return "Limite: " + this.limite + "Num. Cartão: " + this.numCartao + "Validade: " + this.validade;
    }

    public static void menuCartao() {

        System.out.println( "1 - Novo Cartão" );
        System.out.println( "2 - Consultar cartão" );
        System.out.println( "3 - Pagar cartão" );
        System.out.println( "4 - Voltar" );
        System.out.print( "Opção: " );

    }

}