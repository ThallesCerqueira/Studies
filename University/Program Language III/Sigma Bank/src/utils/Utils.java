package utils;

import pessoas.Pessoa;
import java.util.Scanner;
import java.util.ArrayList;
import produtosBancarios.contas.Conta;

public class Utils {

    // Método que mostra Menu Principal
    public static void menuPrincipal() {

        System.out.println( "\n1 - Acessar conta." );
        System.out.println( "2 - Abrir conta." );
        System.out.println( "3 - Nossos funcionários" );
        System.out.println( "4 - Nossos clientes" );
        System.out.println( "5 - Encerrar Programa." );

    }

    // Método que mostra os funcionarios da empresa
    public static void nossosFuncionarios( ArrayList<Pessoa> list ) {

        for( Pessoa pessoa: list ) {
            System.out.println( "Funcionário: " + pessoa.getNome() + ", salário: " + pessoa.getRenda() );
        }

    }

    // Método para mostrar nossos clientes
    public static void nossosClientes( ArrayList<Conta> list ) {

        for( Conta cliente: list ) {
            System.out.println( "Cliente: " + cliente.getNome() );
        }

    }

    public static int opcao( int min, int max ) {

        int opcao;
        Scanner sc = new Scanner( System.in );

        do{
            System.out.print( "\nOpção: " );
            opcao = sc.nextInt();

            if( opcao < min || opcao > max ) System.out.println( "Opção inválida, tente novamente!\n" );
        }while ( opcao < min || opcao > max );

        return opcao;

    }

}