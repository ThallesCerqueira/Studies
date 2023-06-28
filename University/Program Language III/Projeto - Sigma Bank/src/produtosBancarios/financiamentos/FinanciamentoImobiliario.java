package produtosBancarios.financiamentos;

public class FinanciamentoImobiliario extends Financiamento{

    public FinanciamentoImobiliario( int parcelas, double valor ) {
        super( parcelas, valor + (valor * 0.10d) );
    }

}