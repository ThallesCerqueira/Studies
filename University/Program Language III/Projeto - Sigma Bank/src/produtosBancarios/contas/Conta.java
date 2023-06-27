package produtosBancarios.contas;

import utils.Data;
import pessoas.Pessoa;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
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
    Scanner sc = new Scanner( System.in );

    // Rever este construtor
    public Conta() {
        // Gearando um número aleatório para conta.
        this.numConta = random.nextInt( 10000, 99999 );

    }

    // Caso o cliente queira um cartão
    public boolean criarCartao() {

        int dia, senha;
        double limite = limiteCartao();

        System.out.println( "Dia do Vencimento: " );
        dia = sc.nextInt();

        System.out.println( "Senha: " );
        senha = sc.nextInt();

        if( limite > 10000 ) {
            this.cartao = new CartaoBlack( new Data( dia, 12 ), limite, senha );
            return true;
        } else if ( limite > 0 ) {
            this.cartao = new CartaoGold( new Data( dia, 12 ), limite, senha );
            return true;
        }

        return false;

    }

    // Caso o cliente queira um empréstimo
    public boolean criarEmprestimo() {
        int tipo, parcelas;
        double valor;


        System.out.println( "1 - Empréstimo Consignado" );
        System.out.println( "2 - Empréstimo Pessoal" );
        tipo = sc.nextInt();

        System.out.println( "Quantas parcelas? " );
        parcelas = sc.nextInt();
        System.out.println( "Valor do empréstimo? " );
        valor = sc.nextDouble();

        if( tipo == 1 ) {
            this.emprestimo = new EmprestimoConsignado( parcelas, valor );
            return true;
        } else if( tipo == 2 ) {
            this.emprestimo = new EmprestimoPessoal( parcelas, valor );
            return true;
        }

        return false;

    }

    // Caso o cliente queira um Financiamento
    public boolean criarFinanciamento( int tipo ) {

        if( tipo == 1 ) {
            //this.financiamento = new FinanciamentoImobiliario();
            return true;
        }else if( tipo == 2 ) {
            //this.financiamento = new FinanciamentoVeicular();
            return true;
        }

        return false;

    }

    // CRIAR MÉTODO
    private double limiteCartao() {
        return cliente.getRenda() * 0.70;
    }

    protected void setConta( Pessoa cliente ) {
        this.cliente = cliente;
    }

    public long getKeyPessoa() {
        return this.cliente.getKeyPessoa();
    }

    public static Conta acessarConta( ArrayList<Conta> contaList ) {

        int escolha;
        long key;
        Conta conta;
        Scanner sc = new Scanner( System.in );

        do {
            System.out.println( "\n1 - Conta Física." );
            System.out.println( "2 - Conta Jurídica." );
            System.out.print( "\nOpção: " );

            escolha = sc.nextInt();
        }while( escolha < 1 || escolha > 2 );

        if( escolha == 1 ) {
            System.out.print( "\nDigite seu CPF: " );
        } else {
            System.out.print( "\nDigite seu CNPJ: " );
        }

        key = sc.nextInt();
        conta = buscaConta(contaList, key);
        return conta;

    }

    private static Conta buscaConta(ArrayList<Conta> contaList, long key) {
        int i = 0;
        for( Conta conta: contaList ) {
            if( conta.getKeyPessoa() == key) {
                return conta;
            }
            i++;
        }

        return null;
    }

    public static void inicializaContas( ArrayList<Conta> contaList) {
        contaList.add( new ContaCorrente( "Thalles Cerqueira", 123456 , "Rua Nova",1000.0d, 1 ));
        contaList.add( new ContaCorrente( "Company Center", 654321, "Juracy Magalhães", 100000.0d, 2 ) );
    }

    public void acoesConta() {

        int opcao, opcao2;

        System.out.println( "\nBem vindo " + this.cliente.getNome() + "!" );

        do{
            menuConta();
            opcao = sc.nextInt();
            System.out.println();

            // Escolha das ações da conta a partir do menuConta
            switch (opcao) {
                // Opção de visualizar Informações Pessoais
                case 1 :
                    System.out.println( cliente.toString() );
                    break;
                // Opção Área de Cartões
                case 2:
                    Cartao.menuCartao();
                    opcao2 = sc.nextInt();

                    acoesCartao( opcao2 );
                    break;
                // Opção Área de Empréstimos
                case 3:
                    Emprestimo.menuEmprestimo();
                    opcao2 = sc.nextInt();

                    // Função de métodos pertinentes ao Empréstimo.
                    acoesEmprestimo( opcao2 );
                    break;
            }

            if( opcao == 5 ) System.out.println( "Até mais " + this.cliente.getNome() + "!" );

        }while( opcao != 5 );

    }


    private boolean isEmprestimo() {
        return this.emprestimo != null;
    }

    private void acoesEmprestimo( int opcao ) {

        double valorPagamento;

        // Escolha das ações para Emprestimo a partir do menuEmprestimo
        switch (opcao) {

            // Opção para novo Empréstimo
            case 1:
                if(criarEmprestimo()) System.out.println( "Empréstimo criado!" );
                else System.out.println( "Falha ao criar Empréstimo!" );
                break;
            // Opção para ver informações do Empréstimo
            case 2 :
                if( isEmprestimo() ) System.out.println( emprestimo.toString() );
                else System.out.println( "Nenhum empréstimo localizado." );
                break;
            // Opção para pagar Empréstimo
            case 3:
                if( isEmprestimo() ) {
                    System.out.println( "Valor do pagamento: " );
                    valorPagamento = sc.nextDouble();

                    if( emprestimo.pagar( valorPagamento ) ) System.out.println( "Pagamento efetuado" );
                    else System.out.println( "Pagamento não efetuado!" );
                }
                break;
            // Opção de voltar à tela anterior
            case 4 :
                break;
        }

    }

    private void acoesCartao( int opcao ) {

        double valorPagamento;

        // Escolha das ações para Cartão a partir do menuCartao
        switch (opcao) {

            // Opção para novo Cartão
            case 1:
                if(criarCartao()) System.out.println( "Cartão criado!" );
                else System.out.println( "Falha ao criar Cartão!" );
                break;
            // Opção para ver informações do Cartão
            case 2:
                if( isCartao() ) System.out.println( cartao.toString() );
                else System.out.println( "\nNenhum cartão localizado!" );
                break;
            // Opção para pagar Cartão
            case 3:
                if( isCartao() ) {
                    System.out.println( "Valor do pagamento: " );
                    valorPagamento = sc.nextDouble();

                    if( cartao.pagar( valorPagamento ) ) System.out.println( "Pagamento efetuado" );
                    else System.out.println( "Pagamento não efetuado!" );
                }
                break;
            // Opção de voltar à tela anterior
            case 4:
                break;
        }

    }

    private boolean isCartao() {
        return this.cartao != null;
    }

    public void menuConta() {

        System.out.println("\nMENU: ");
        System.out.println( "1 - Informações Pessoais" );
        System.out.println( "2 - Área de Cartões" );
        System.out.println( "3 - Área de Emprestimos" );
        System.out.println( "4 - Área de financiamentos" );
        System.out.println( "5 - Encerrar sessão" );
        System.out.print( "\nOpção: " );

    }

}
