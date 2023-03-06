package br.com.fiap.banco;

public class ContaCorrente extends Conta {

    private String tipo;
    private double ChequeEspecial;

    public void setTipo( String tipo ){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.ChequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return ChequeEspecial;
    }

    @Override
    public double getSaldo() {
        return saldo + this.ChequeEspecial;
    }

    @Override
    public void retirar(double valor){
        valor = valor + 10;
        super.retirar(valor);
    }
}
