import java.util.Scanner;

public class Multimetro {

    public static void main(String[] args) {

        int tamVet = 10;
        Double[] vetMultimetros = new Double[10];
        Double valorMedio, dPadrao, auxiliar, porcentoValorMedio;

        valorMedio = dPadrao = 0.0d;
        Scanner sc = new Scanner( System.in );

        System.out.println("Equipe de manutenção - Bem vindo!\n\n");

        //Leitura dos valores dos Multímetros
        for( int i = 0; i < tamVet; i++ ) {

            System.out.println( "Entre com a voltagem do " + (i+1) + "º multímetro: " );
            vetMultimetros[i] = sc.nextDouble();

            valorMedio += ( vetMultimetros[i] / tamVet );

        }

        //Cálculo do Desvio Padrão
        for( int i = 0; i < tamVet; i++ ) {

            auxiliar = (vetMultimetros[i] - valorMedio) * (vetMultimetros[i] - valorMedio);

            dPadrao +=  Math.sqrt( auxiliar / tamVet );

        }

        //Cálculo da porcentagem do valor Médio
        porcentoValorMedio = valorMedio * (0.10f);

        //Estética.
        System.out.println( " " );

        //Output dos valores lidos
        for( int i = 0; i < tamVet; i++ ) {

            System.out.println( "Voltagem do " +  (i + 1) + "º Multímetro: " + vetMultimetros[i] );

        }

        //Output do valor médio
        System.out.println( "\nValor médio: " + valorMedio );

        //Output da porcentagem do valor médio
        System.out.println( "Porcento valor médio: " + porcentoValorMedio );

        //Output do desvio padrão
        System.out.println( "Desvio Padrão: " + dPadrao );

        //Output do estado do Multímetro
        if( dPadrao > porcentoValorMedio ) {

            System.out.println( "RESULTADO: Multímetro com defeito!" );

        } else {

            System.out.println( "RESULTADO: Multímetro em perfeitas condições." );

        }

    }

}