package produtosBancarios.emprestimos;

import utils.Gerais;
import java.util.Scanner;

public abstract class Emprestimo implements Gerais {

    // Atributos da Classe
    private int qtdParcelas;
    private int parcelasPagas;
    private double valor;
    Scanner sc = new Scanner( System.in );

    // Construtor com 2 parâmetros
    public Emprestimo( int qtdParcelas, double valor ) {
        this.qtdParcelas = qtdParcelas;
        this.valor = valor;
    }

    // Sobreescrita do método pagar, previsto pela Interface
    @Override
    public boolean pagar( double valor ) {

        if( this.valor >= valor ) {
            this.valor -= valor;
            this.parcelasPagas--;
            return true;
        }

        return false;

    }

    // Sobreescrita do método getSaldo, previsto pela Interface
    @Override
    public double getSaldo() {
        return this.valor;
    }

    // Sobreescrita do método toStringo, previsto pela Interface
    public String toString() {
        return "Valor: " + this.valor + ", Parcelas: " + this.qtdParcelas + ", Parcelas Pagas:" + this.parcelasPagas;
    }

    // Método que mostra as opções para o Empréstimo
    public static void menuEmprestimo() {

        System.out.println( "1 - Novo empréstimo" );
        System.out.println( "2 - Consultar empréstimo" );
        System.out.println( "3 - Pagar empréstimo" );
        System.out.println( "4 - Voltar" );

    }

    // Método de verificação para Empréstimo
    public static boolean isEmprestimo( Emprestimo emprestimo ) {
        return emprestimo != null;
    }

}