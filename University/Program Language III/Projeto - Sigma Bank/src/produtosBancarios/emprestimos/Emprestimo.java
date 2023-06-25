package produtosBancarios.emprestimos;

import utils.Gerais;

public abstract class Emprestimo implements Gerais {

    private int qtdParcelas;
    private int parcelasPagas;
    private double valor;

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

    @Override
    public String toString() {
        return "Valor: " + this.valor + ", Parcelas: " + this.qtdParcelas + ", Parcelas Pagas:" + this.parcelasPagas;
    }

}
