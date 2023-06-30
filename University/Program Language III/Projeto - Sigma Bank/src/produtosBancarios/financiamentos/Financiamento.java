package produtosBancarios.financiamentos;

import utils.Gerais;

public class Financiamento implements Gerais {

    // Atributos da Classe
    private int qtdParcelas;
    private int parcelasPagas;
    private double valor;

    // Construtor com 2 parâmetros
    public Financiamento( int parcelas, double valor ) {

        if( financiamentoValido( parcelas, valor ) ) {
            this.qtdParcelas = parcelas;
            this.valor = valor;
            this.parcelasPagas = 0;
        }

    }

    // Método para verificar se os valores são válidos
    private boolean financiamentoValido( int parcelas, double valor ) {
        return parcelas > 0 && valor > 0;
    }

    // Sobreescrita do método getSaldo, previsto na Interface
    @Override
    public double getSaldo() {
        return this.valor;
    }

    // Sobreescrita do método pagar, previsto na Interface
    @Override
    public boolean pagar( double valor ) {
        if( this.valor > valor ) {
            this.valor -= valor;
            this.parcelasPagas ++;
            return true;
        }

        return false;
    }

    // Sobreescrita do método toString, previsto na Interface
    @Override
    public String toString() {
        return "Valor: " + this.valor + ", Parcelas: " + this.qtdParcelas + ", Parcelas Pagas:" + this.parcelasPagas;
    }

    // Método que mostra opções do Menu de Financiamento
    public static void menuFinanciamento() {

        System.out.println( "1 - Novo financiamento" );
        System.out.println( "2 - Consultar financiamento" );
        System.out.println( "3 - Pagar financiamento" );
        System.out.println( "4 - Voltar" );
        System.out.print( "Opção: " );

    }

}