package produtosBancarios.emprestimos;

import utils.Gerais;
import java.util.Scanner;

public abstract class Emprestimo implements Gerais {

    private int qtdParcelas;
    private int parcelasPagas;
    private double valor;

    // Objetos
    Scanner sc = new Scanner( System.in );

    public Emprestimo( int qtdParcelas, double valor ) {
        this.qtdParcelas = qtdParcelas;
        this.valor = valor;
    }


    @Override
    public boolean pagar( double valor ) {

        if( this.valor >= valor ) {
            this.valor -= valor;
            this.parcelasPagas--;
            return true;
        }

        return false;

    }

    @Override
    public double getSaldo() {
        return this.valor;
    }

    public String toString() {
        return "Valor: " + this.valor + ", Parcelas: " + this.qtdParcelas + ", Parcelas Pagas:" + this.parcelasPagas;
    }

    public static void menuEmprestimo() {

        System.out.println( "1 - Novo empréstimo" );
        System.out.println( "2 - Consultar empréstimo" );
        System.out.println( "3 - Pagar empréstimo" );
        System.out.println( "4 - Voltar" );
        System.out.print( "Opção: " );

    }

}