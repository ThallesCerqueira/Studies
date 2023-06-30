package produtosBancarios.financiamentos;

public class FinanciamentoImobiliario extends Financiamento{

    // Construtor com 2 parâmetros
    public FinanciamentoImobiliario( int parcelas, double valor ) {

        // Chamando Construtor da Super Class
        // Diferença na taxa de Juros
        super( parcelas, valor + (valor * 0.10d) );
    }

}