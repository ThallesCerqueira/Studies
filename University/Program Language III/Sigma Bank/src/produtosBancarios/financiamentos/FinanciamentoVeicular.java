package produtosBancarios.financiamentos;

public class FinanciamentoVeicular extends Financiamento {

    private static final double taxa = 0.20d;

    // Construtor com 2 parâmetros
    public FinanciamentoVeicular( int parcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de juros
        super( parcelas, valor + (valor * taxa) );
    }

}