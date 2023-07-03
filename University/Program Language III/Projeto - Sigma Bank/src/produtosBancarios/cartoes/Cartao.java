package produtosBancarios.cartoes;

import utils.Data;
import utils.Gerais;

public abstract class Cartao implements Gerais {

    // Atributos da Classe
    private Data vencimento;
    private Data validade;
    private double limite;
    private final double anuidade = 0d;
    private double fatura;
    private long numCartao;
    private int senha;

    // Construtor com 3 parâmetros
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

    // Construtor com 2 parâmetros
    public Cartao( double limite, int senha ) {
        this( null, limite, senha );
    }

    // Método para verificar se os dados são válidos
    private boolean validaCartao( Data vencimento, double limite ) {
        return vencimento != null && limite >= 0;
    }

    // Sobreescrita do método pagar, previsto na Interface
    @Override
    public boolean pagar( double pagamento ) {

        if( this.fatura >= pagamento ) {
            this.fatura -= pagamento;
            return true;
        }

        return false;

    }

    // Método para compra com o Cartão
    public boolean comprarAlgo( double valor ) {

        if( this.limite >= valor ) {
            this.limite -= valor;
            this.fatura += valor;
            return true;
        }

        return false;
    }

    // Sobreescrita do método getSaldo, previsto na Interface
    @Override
    public double getSaldo() {
        return this.limite;
    }

    // Sobreescrita do método toString, previsto na Interface
    @Override
    public String toString() {
        return "Limite: " + this.limite + "Num. Cartão: " + this.numCartao + "Validade: " + this.validade;
    }

    // Menu para o cartão
    public static void menuCartao() {

        System.out.println( "1 - Novo Cartão" );
        System.out.println( "2 - Consultar cartão" );
        System.out.println( "3 - Pagar cartão" );
        System.out.println( "4 - Voltar" );

    }

    // Método de verificação para Cartão
    public static boolean isCartao( Cartao cartao ) {
        return cartao != null;
    }

}