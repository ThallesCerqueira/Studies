import produtosBancarios.contas.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner( System.in );

    public static void main(String[] args)  {

        // Variáveis
        int escolha = 0;
        Conta contaAtual;
        ArrayList<Conta> contaList = new ArrayList<>();

        System.out.println(" ========= Bem-Vindo ao Sigma Bank ========= ");

        while( escolha != 5 ) {

            // Verificando a opção do Usuário
            do {
                menuPrincipal();
                escolha = sc.nextInt();

                if( escolha < 1 || escolha > 6 ) System.out.println( "Opção inválida." );

            } while ( escolha < 1 || escolha > 6);

            switch ( escolha ) {
                case 1:
                    contaAtual = acessarConta();
                    break;
                case 2:
                    contaAtual = abrirConta();
            }


        }

    }


    public static void menuPrincipal() {

        System.out.println( "1 - Acessar conta." );
        System.out.println( "2 - Abrir conta." );
        System.out.println( "3 - Encerrar Sessão." );
        System.out.print(" Opção: ");

    }

    public static Conta acessarConta( ArrayList<Conta> contaList ) {

        int escolha;

        do {
            System.out.println( "\n1 - Conta Física." );
            System.out.println( "2 - Conta Jurídica." );

            escolha = sc.nextInt();
        }while( escolha < 1 || escolha > 2 );

        if( escolha == 1 ) {

        }


    }

    private static Conta abrirConta() {
    }
}

