package produtosBancarios.financiamentos;

public class FinanciamentoVeicular extends Financiamento {

    // Construtor com 2 parâmetros
    public FinanciamentoVeicular( int parcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de juros
        super( parcelas, valor + (valor * 0.20d) );
    }

}