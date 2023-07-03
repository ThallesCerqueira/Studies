package produtosBancarios.financiamentos;

public class FinanciamentoImobiliario extends Financiamento {

    private static final double taxa = 0.10d;

    // Construtor com 2 parâmetros
    public FinanciamentoImobiliario( int parcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de Juros
        super( parcelas, valor + (valor * taxa) );
    }

}