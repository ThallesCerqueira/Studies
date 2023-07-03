package utils;

import java.util.Scanner;

public class ClasseUtils {

    // Método que mostra Menu Principal
    public static void menuPrincipal() {

        System.out.println("\n1 - Acessar conta.");
        System.out.println("2 - Abrir conta.");
        System.out.println("3 - Encerrar Programa.");
        System.out.print("\nOpção: ");

    }

    public static int opcao( int min, int max ) {

        int opcao;
        Scanner sc = new Scanner( System.in );

        do{
            System.out.print( "Opção: " );
            opcao = sc.nextInt();

            if( opcao < min || opcao > max ) System.out.println( "Opção inválida, tente novamente!" );
        }while ( opcao < min || opcao > max );

        return opcao;

    }

}