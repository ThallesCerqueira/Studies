package produtosBancarios.contas;

import utils.Data;
import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;

public class ContaCorrente extends Conta {

    private double limiteCheque;
    private double saldoDevedorCheque;

    // Construtor com 6 parâmetros
    public ContaCorrente( String nome, long key, Data data, String endereco, double renda, int tipo, String senha ) {

        // Chamando Construtor da Super Class
        super( senha );

        // Escolhendo se será Pessoa Física ou Jurídica
        if( tipo == 1 ) {

            setCliente( new PessoaFisica( nome, key, data, endereco,renda ));
        } else if ( tipo == 2 ) {

            setCliente( new PessoaJuridica( nome, key, data, endereco,renda ));
        }

        limiteCheque = calculaLimiteCheque();
    }


    // Sobreescrita do método sacar, adição do cheque especial
    @Override
    public boolean sacar( double valor ) {

        double saldoDaConta;

        if( !super.sacar( valor ) ) {

            saldoDaConta = super.getSaldo();

            if( this.limiteCheque + saldoDaConta >= valor ) {

                super.sacar( saldoDaConta );
                this.limiteCheque -= valor - saldoDaConta;
                this.saldoDevedorCheque = valor - saldoDaConta;

                return true;

            }

            return false;

        }else {
            return true;
        }

    }

    // Método auxiliar, para calculo do limite máximo para cheque especial
    private double calculaLimiteCheque() {
        return getRenda() * 0.40;
    }

    // Método auxiliar, para saber limite do cheque
    public double getLimiteCheque() {
        return this.limiteCheque;
    }

    // Método auxiliar, para saber saldo devedor do cheque especial
    public double getSaldoDevedorCheque() {
        return this.saldoDevedorCheque;
    }

    // Sobreescrita do método
    @Override
    public void subacoesConta( int opcao ) {
        super.subacoesConta( opcao );

        if( opcao == 2 ) {
            System.out.println( "Limite do Cheque especial: " + this.limiteCheque );
            System.out.println( "Saldo devedor Cheque especial: " + this.saldoDevedorCheque );
        }
    }

    // Método para pagar o cheque especial
    public boolean pagarCheque( double valor ) {

        if( this.limiteCheque < calculaLimiteCheque() ) {
            this.limiteCheque += valor;
            this.saldoDevedorCheque -= valor;

            return true;
        }

        return false;

    }

}