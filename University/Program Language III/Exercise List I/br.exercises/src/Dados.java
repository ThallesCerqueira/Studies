import java.util.Random;

public class Dados {

    public static void main(String[] args) {

        int dado1, dado2, ponto, soma, i;
        i = 1;

        Random random = new Random();

        dado1 = 1 + random.nextInt(5);
        dado2 = 1 + random.nextInt(5);

        soma = dado1 + dado2;

        if (soma == 7 || soma == 11) {

            System.out.println( "Dado 1: " + dado1 + ", Dado 2: " + dado2 );
            System.out.println( "Soma: " + soma );
            System.out.println( "\nVocê ganhou :-)" );

        } else if( soma == 2 || soma == 3 || soma == 12 ) {

            System.out.println( "Dado 1: " + dado1 + ", Dado 2: " + dado2 );
            System.out.println( "Soma: " + soma );
            System.out.println( "Você perdeu :-(" );

        } else {

            ponto = soma;

            System.out.println( "Dado 1: " + dado1 + ", Dado 2: " + dado2 );
            System.out.println( "Ponto: " + ponto);

            System.out.println( "\nIniciando estágio 2" );

            do {

                dado1 = 1 + random.nextInt(5);
                dado2 = 1 + random.nextInt(5);
                soma = dado1 + dado2;

                System.out.println( "\nDado 1: " + dado1 + ", Dado 2: " + dado2 );
                System.out.println("Jogada " +  i + ": " + soma);


                if ( soma == ponto ) {

                    System.out.println( "\nVocê ganhou :-)" );
                    break;

                }else if ( soma == 7 ) {

                    System.out.println( "\nVocê perdeu :-(" );
                    break;

                }

                i++;

            }while ( soma != ponto );

        }

    }

}