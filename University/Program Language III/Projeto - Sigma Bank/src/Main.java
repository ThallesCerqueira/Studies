import produtosBancarios.contas.Conta;
import produtosBancarios.contas.ContaCorrente;
import produtosBancarios.contas.ContaPoupanca;
import utils.Data;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    static Scanner sc = new Scanner( System.in );

    public static void main(String[] args)  {

        // Variáveis
        int escolha = 0;
        Conta contaAtual = null;
        ArrayList<Conta> contaList = new ArrayList<>();
        Conta.inicializaContas( contaList );

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while( escolha != 5 ) {

            // Verificando a opção do Usuário
            do {
                menuPrincipal();
                escolha = sc.nextInt();

                if( escolha < 1 || escolha > 6 ) System.out.println( "Opção inválida." );

            } while ( escolha < 1 || escolha > 6);

            switch (escolha) {
                case 1 -> contaAtual = Conta.acessarConta( contaList );
                case 2 -> contaAtual = abrirConta( contaList );
                case 3 -> {
                    exit(0);
                }
            }

            if( contaAtual != null ) {
                contaAtual.acoesConta();
            } else {
                System.out.println( "\nConta não localizada. Tente novamente!" );
            }

        }

    }

    public static void menuPrincipal() {

        System.out.println( "\n1 - Acessar conta." );
        System.out.println( "2 - Abrir conta." );
        System.out.println( "3 - Encerrar Programa." );
        System.out.print("\nOpção: ");

    }

    private static Conta abrirConta( ArrayList<Conta> contaList ) {

        String nome, endereco;
        long key;
        double renda;
        int opcao, opcao2, dia, mes, ano;
        Scanner sc = new Scanner( System.in );
        Conta conta;

        System.out.println( " === ABERTURA DE CONTA === " );

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

        System.out.print( "Nome: " );
        nome = sc.nextLine();

        if( opcao == 1 ) {
            System.out.println( "Cpf: " );
            key = sc.nextLong();
            System.out.print( "Data de nascimento:\nDia: " );
        }
        else {
            System.out.println( "Cnpj: " );
            key = sc.nextLong();
            System.out.print( "Data de Abertura:\nDia: " );
        }
        dia = sc.nextInt();
        System.out.print( "Mês: " );
        mes = sc.nextInt();
        System.out.print( "Ano: " );
        ano = sc.nextInt();

        System.out.print( "Endereço: " );
        endereco = sc.nextLine();

        System.out.print( "Renda: " );
        renda  = sc.nextDouble();

        if( opcao == 1 && opcao2 == 1 ) {
            conta = new ContaCorrente( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            contaList.add(conta);
            return  conta;
        } else if (opcao == 1) {
            conta = new ContaCorrente( nome, key, new Data(dia, mes, ano), endereco, renda, 2 );
            contaList.add(conta);
            return  conta;
        } else if(opcao2 == 1) {
            conta = new ContaPoupanca( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            contaList.add(conta);
            return conta;
        } else {
            conta = new ContaPoupanca( nome, key, new Data(dia, mes, ano), endereco, renda, 1 );
            contaList.add(conta);
            return conta;
        }

    }
}

