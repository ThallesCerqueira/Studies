package produtosBancarios.financiamentos;

import utils.Gerais;

public class Financiamento implements Gerais {

    private int qtdParcelas;
    private int parcelasPagas;
    private double valor;


    public Financiamento( int parcelas, double valor ) {

        if( financiamentoValido( parcelas, valor ) ) {
            this.qtdParcelas = parcelas;
            this.valor = valor;
            this.parcelasPagas = 0;
        }

    }

    private boolean financiamentoValido(int parcelas, double valor) {
        return parcelas > 0 && valor > 0;
    }

    @Override
    public double getSaldo() {
        return this.valor;
    }

    @Override
    public boolean pagar( double valor ) {
        if( this.valor > valor ) {
            this.valor -= valor;
            this.parcelasPagas ++;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Valor: " + this.valor + ", Parcelas: " + this.qtdParcelas + ", Parcelas Pagas:" + this.parcelasPagas;
    }

}
