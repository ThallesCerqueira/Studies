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

    // Atributos da Classe
    private int numConta;
    private double saldo;
    private Pessoa cliente;
    private Cartao cartao;
    private Emprestimo emprestimo;
    private Financiamento financiamento;
    private static int qtdContas = 0;
    Random random = new Random( 123 );
    Scanner sc = new Scanner( System.in );

    // Construtor sem parâmetros
    public Conta() {
        // Gearando um número aleatório para conta
        this.numConta = random.nextInt( 10000, 99999 );
        this.saldo = 0;

        // Atualizando o número de Contas Instanciadas
        qtdContas++;

    }

    public static Conta abrirConta( ArrayList<Conta> contaList ) {

        // Variáveis
        String nome, endereco;
        long key;
        double renda;
        int opcao, opcao2, dia, mes, ano;
        Scanner sc = new Scanner( System.in );
        Conta conta;

        System.out.println( " === ABERTURA DE CONTA === " );

        // Output e Intput
        System.out.println( "\n1 - Conta Corrente\n2 - Conta Poupança" );
        do{
            System.out.print( "Opção: " );
            opcao2 = sc.nextInt();
            if( opcao2 < 1 || opcao2 > 2 ) System.out.println( "Opção inválida! Tente novamente" );
        } while ( opcao2 < 1 || opcao2   > 2 );

        System.out.println( "\n1 - Pessoa física\n2 - Pessoa Jurídica" );
        do{
            System.out.print( "Opção: " );
            opcao = sc.nextInt();
            if( opcao < 1 || opcao > 2 ) System.out.println( "Opção inválida! Tente novamente" );
        } while ( opcao < 1 || opcao > 2 );

        sc.nextLine();
        System.out.print( "Nome: " );
        nome = sc.nextLine();

        if( opcao == 1 ) {
            System.out.print( "Cpf: " );
            key = sc.nextLong();
            System.out.print( "Data de nascimento:\nDia: " );
        }
        else {
            System.out.print( "Cnpj: " );
            key = sc.nextLong();
            System.out.print( "Data de Abertura:\nDia: " );
        }
        dia = sc.nextInt();
        System.out.print( "Mês: " );
        mes = sc.nextInt();
        System.out.print( "Ano: " );
        ano = sc.nextInt();

        sc.nextLine();
        System.out.print( "Endereço: " );
        endereco = sc.nextLine();

        System.out.print( "Renda: " );
        renda  = sc.nextDouble();

        // Escolha de qual Conta será instanciada, levando em consideração a pessoa (CPF/CNPJ)
        if( opcao == 1 && opcao2 == 1 ) {

            conta = new ContaCorrente( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            // Adicionando conta criada à Lista
            contaList.add(conta);
            return conta;

        } else if (opcao == 1) {

            conta = new ContaCorrente( nome, key, new Data(dia, mes, ano), endereco, renda, 2 );
            // Adicionando conta criada à Lista
            contaList.add(conta);
            return conta;

        } else if(opcao2 == 1) {

            conta = new ContaPoupanca( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            // Adicionando conta criada à Lista
            contaList.add(conta);
            return conta;

        } else {

            conta = new ContaPoupanca( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            // Adicionando conta criada à Lista
            contaList.add(conta);
            return conta;
        }

    }

    // Método estático de acesso à conta
    public static Conta acessarConta( ArrayList<Conta> contaList ) {

        // Variáveis
        int escolha;
        long key;
        Conta conta;
        Scanner sc = new Scanner( System.in );

        // Output e Inputs
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

        // Pegando a chave de acesso e fazendo a busca nas contas já existentes.
        key = sc.nextInt();
        conta = buscaConta(contaList, key);

        return conta;
    }

    // Método auxiliar para buscar uma conta
    private static Conta buscaConta( ArrayList<Conta> contaList, long key ) {

        // Variáveis
        int i = 0;

        // Looping que percorre a nossa lista
        for( Conta conta: contaList ) {

            if( conta.getKeyPessoa() == key) {
                return conta;
            }
            i++;
        }

        return null;
    }

    // Método auxiliar para popular o banco de contas/pessoas
    public static void inicializaContas( ArrayList<Conta> contaList ) {
        contaList.add( new ContaCorrente( "Thalles Cerqueira", 123456 , new Data(), "Rua Nova", 1000.0d, 1 ) );
        contaList.add( new ContaCorrente( "Company Center", 654321, new Data(), "Juracy Magalhães", 100000.0d, 2 ) );
    }

    // Caso o cliente queira criar um cartão
    public boolean criarCartao() {

        // Variáveis
        int dia, senha;
        double limite = limiteCartao();

        // Output e Input
        System.out.println( "Dia do Vencimento: " );
        dia = sc.nextInt();
        System.out.println( "Senha: " );
        senha = sc.nextInt();

        // Verificação de qual cartão será criado. É arbitrário.
        if( limite > 10000 ) {
            System.out.println( "Cartão a ser criado: Cartão Black" );
            this.cartao = new CartaoBlack( new Data( dia, 12 ), limite, senha );
            return true;
        } else if ( limite > 0 ) {
            System.out.println( "Cartão a ser criado: Cartão Gold" );
            this.cartao = new CartaoGold( new Data( dia, 12 ), limite, senha );
            return true;
        }

        return false;
    }

    // Caso o cliente queira criar um empréstimo
    public boolean criarEmprestimo() {

        // Variáveis
        int tipo, parcelas;
        double valor;

        // Output e Input
        System.out.println( "1 - Empréstimo Consignado" );
        System.out.println( "2 - Empréstimo Pessoal" );
        tipo = sc.nextInt();

        System.out.println( "Quantas parcelas? " );
        parcelas = sc.nextInt();
        System.out.println( "Valor do empréstimo? " );
        valor = sc.nextDouble();

        // Escolha de qual Empréstimo será criado, de acordo com a escolha do cliente.
        if( tipo == 1 ) {
            this.emprestimo = new EmprestimoConsignado( parcelas, valor );
            return true;
        } else if( tipo == 2 ) {
            this.emprestimo = new EmprestimoPessoal( parcelas, valor );
            return true;
        }

        return false;

    }

    // Caso o cliente queira criar um Financiamento
    public boolean criarFinanciamento() {

        // Variáveis
        int tipo, parcelas;
        double valor;

        // Output e Input
        System.out.println( "1 - Financiamento Imobiliário" );
        System.out.println( "2 - Financiamento Veicular" );
        tipo = sc.nextInt();

        System.out.println( "Quantas parcelas: " );
        parcelas = sc.nextInt();
        System.out.println( "Valor do Financiamento: " );
        valor = sc.nextDouble();

        // Escolha de qual Financiamento será criado
        if( tipo == 1 ) {
            this.financiamento = new FinanciamentoImobiliario( parcelas, valor );
            return true;
        } else if( tipo == 2 ) {
            this.financiamento = new FinanciamentoVeicular( parcelas, valor );
            return true;
        }

        return false;
    }

    // Método de ações da Conta
    public void acoesConta() {

        // Variáveis
        int opcao, opcao2;

        System.out.println( "\nBem vindo " + this.cliente.getNome() + "!" );

        // Looping para permanência das ações
        do{
            // Output do menu
            menuConta();

            // Input da escolha
            opcao = sc.nextInt();
            System.out.println();

            // Escolha das ações da conta a partir do menuConta
            switch (opcao) {
                // Opção de visualizar Informações Pessoais
                case 1 -> {
                    subMenuConta();
                    opcao2 = sc.nextInt();
                    subacoesConta( opcao2 );

                }

                // Opção Área de Cartões
                case 2 -> {
                    Cartao.menuCartao();
                    opcao2 = sc.nextInt();
                    acoesCartao(opcao2);
                }
                // Opção Área de Empréstimos
                case 3 -> {
                    Emprestimo.menuEmprestimo();
                    opcao2 = sc.nextInt();

                    // Função de métodos pertinentes ao Empréstimo.
                    acoesEmprestimo(opcao2);
                }
                case 4 -> {
                    Financiamento.menuFinanciamento();
                    opcao2 = sc.nextInt();

                    // Função de métodos pertinentes ao Financiamento
                    acoesFinanciamento(opcao2);
                }

                case 5 -> {
                    // Opção para encerrar, break implícito.
                }
            }

            // Mensagem de despedida, para caso o cliente queira sair da conta
            if( opcao == 5 ) System.out.println( "Até mais " + this.cliente.getNome() + "!" );

        }while( opcao != 5 );

    }

    // Método de ações para Empréstimo
    private void acoesEmprestimo( int opcao ) {

        // Variáveis
        double valorPagamento;

        // Escolha das ações para Emprestimo a partir do menuEmprestimo
        switch (opcao) {

            // Opção para novo Empréstimo
            case 1:
                if( criarEmprestimo() ) System.out.println( "Empréstimo criado!" );
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

    // Método de ações para Cartão
    private void acoesCartao( int opcao ) {

        // Variáveis
        double valorPagamento;

        // Escolha das ações para Cartão a partir do menuCartao
        switch (opcao) {

            // Opção para novo Cartão
            case 1:
                if( criarCartao() ) System.out.println( "Cartão criado!" );
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

    // Método de ações para Financiamento
    private void acoesFinanciamento( int opcao ) {

        // Variáveis
        double valorPagamento;

        // Escolha das ações para Financiamento a partir do menuFinanciamento
        switch (opcao) {

            // Opção para novo Financiamento
            case 1:
                if( criarFinanciamento() ) System.out.println( "Financiamento criado!" );
                else System.out.println( "Falha ao criar Financiamento!" );
                break;

            // Opção para ver informações do Financiamento
            case 2 :
                if( isFinanciamento() ) System.out.println( financiamento.toString() );
                else System.out.println( "Nenhum financiamento localizado." );
                break;

            // Opção para pagar Financiamento
            case 3:
                if( isFinanciamento() ) {
                    System.out.println( "Valor do pagamento: " );
                    valorPagamento = sc.nextDouble();

                    if( financiamento.pagar( valorPagamento ) ) System.out.println( "Pagamento efetuado" );
                    else System.out.println( "Pagamento não efetuado!" );
                }
                break;

            // Opção de voltar à tela anterior
            case 4 :
                break;
        }

    }

    // Método de verificação para Empréstimo
    private boolean isEmprestimo() {
        return this.emprestimo != null;
    }

    // Método de verificação para Financiamento
    private boolean isFinanciamento() {
        return this.financiamento != null;
    }

    // Método de verificação para Cartão
    private boolean isCartao() {
        return this.cartao != null;
    }

    // Método auxiliar para mostrar o Menu da Conta
    private void menuConta() {

        System.out.println("\nMENU: ");
        System.out.println( "1 - Informações da Conta" );
        System.out.println( "2 - Área de Cartões" );
        System.out.println( "3 - Área de Emprestimos" );
        System.out.println( "4 - Área de financiamentos" );
        System.out.println( "5 - Encerrar sessão" );
        System.out.print( "\nOpção: " );

    }

    // Método auxiliar para mostrar o subMenu da Conta
    private void subMenuConta() {

        System.out.println( "1 - Dados pessoais" );
        System.out.println( "2 - Saldo da conta" );
        System.out.println( "3 - Depositar dinheiro" );
        System.out.println( "4 - Sacar dinheiro" );
        System.out.println( "5 - Voltar" );
        System.out.print( "Opção: " );

    }

    // Método para as subações da conta
    public void subacoesConta( int opcao ) {

        switch (opcao) {
            case 1 -> {
                System.out.println( cliente.toString() );
            }

            case 2 -> {
                System.out.println( "Saldo: " + getSaldo() );
            }

            case 3 -> {
                double valor;
                System.out.print( "Valor: " );
                valor = sc.nextDouble();

                setSaldo( valor );
                System.out.println( "Deposito realizado com sucesso!" );

            }

            case 4 -> {
                double valor;
                System.out.print( "Valor: " );
                valor = sc.nextDouble();

                if (sacar( valor )) {
                    System.out.println( "Saque realizado com sucesso!" );
                }else {
                    System.out.println( "Saldo insuficiente!" );
                }

            }

            case 5 -> {
                // Opção para retornar à tela anterior
            }
        }

    }

    // Método que retorna limite máximo para o Cartão, de acordo com a renda do cliente
    private double limiteCartao() {
        return cliente.getRenda() * 0.70;
    }

    // Método auxiliar, para settar um cliente a uma conta
    protected void setCliente( Pessoa cliente ) {
        this.cliente = cliente;
    }

    // Método para pegar quantidade de contas instanciadas
    public static int getQtdContas() {
        return qtdContas;
    }

    // Método auxiliar, para pegar a chave da pessoa, sendo este CPF ou CNPJ
    public long getKeyPessoa() {
        return this.cliente.getKeyPessoa();
    }

    // Método auxiliar, para pegar o salario do cliente
    public double getRenda() {
        return cliente.getRenda();
    }

    // Método para saber o saldo
    public double getSaldo() {
        return this.saldo;
    }

    // Método para adicionar saldo na conta
    public void setSaldo( double saldo ) {
        this.saldo = saldo;
    }

    // Método para realizar saque
    public boolean sacar( double valor ) {

        if( this.saldo >= valor ) {
            this.saldo -= valor;
            return true;
        }

        return false;

    }

}