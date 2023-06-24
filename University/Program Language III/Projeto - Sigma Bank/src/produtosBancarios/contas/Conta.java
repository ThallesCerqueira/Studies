package produtosBancarios.contas;

import utils.Data;
import pessoas.Pessoa;
import java.util.Random;
import produtosBancarios.cartoes.*;
import produtosBancarios.emprestimos.*;
import produtosBancarios.financiamentos.*;

public abstract class Conta {

    private int numConta;
    private Pessoa cliente;
    private Cartao cartao;
    private Emprestimo emprestimo;
    private Financiamento financiamento;
    Random random = new Random( 123 );

    // Rever este construtor
    public Conta() {
        // Gearando um número aleatório para conta.
        this.numConta = random.nextInt( 10000, 99999 );

    }

    // Caso o cliente queira um cartão
    public boolean criarCartao( Data vencimento, int senha ) {

        double limite = limiteCartao();

        if( limite > 10000 ) {
            this.cartao = new CartaoBlack( vencimento, limite, senha );
            return true;
        } else if ( limite > 0 ) {
            this.cartao = new CartaoGold( vencimento, limite, senha );
        }

        return false;

    }

    // Caso o cliente queira um empréstimo
    public boolean criarEmprestimo( int tipo ) {

        if( tipo == 1 ) {
            this.emprestimo = new EmprestimoConsignado();
            return true;
        } else if( tipo == 2 ) {
            this.emprestimo = new EmprestimoPessoal();
            return true;
        }

        return false;

    }

    // Caso o cliente queira um Financiamento
    public boolean criarFinanciamento( int tipo ) {

        if( tipo == 1 ) {
            this.financiamento = new FinanciamentoImobiliario();
            return true;
        }else if( tipo == 2 ) {
            this.financiamento = new FinanciamentoVeicular();
            return true;
        }

        return false;

    }

    // CRIAR MÉTODO
    private double limiteCartao() {
        return 0;
    }

    protected void setConta( Pessoa cliente ) {
        this.cliente = cliente;
    }

}
