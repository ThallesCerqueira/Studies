package produtosBancarios.financiamentos;

public class FinanciamentoVeicular extends Financiamento {

    public FinanciamentoVeicular( int parcelas, double valor ) {
        super( parcelas, valor + (valor * 0.20d) );
    }

}
