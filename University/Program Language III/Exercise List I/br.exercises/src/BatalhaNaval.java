import java.util.Scanner;

public class BatalhaNaval {

    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );

        int[][]entradasPlayer = new int[5][2];
        char [][]mapa1 = new char[5][5];
        char [][]mapa2 = new char[5][5];

        int i, j, contador, contadorGeral;
        contadorGeral = 0;

        System.out.println( "Welcome to battleship!!!\n" );

        while ( contadorGeral < 2 ){
            i = j = 0;

            System.out.println( "PLAYER " + (contadorGeral + 1) +  ", ENTER YOUR SHIP'S COORDINATES" );

            //LEITURA DOS VALORES DOS PLAYERS
            for( contador = 0; contador < 5; contador++ ){

                System.out.println( "Enter your " + (contador + 1) + " location: " );

                //leitura de x e y
                entradasPlayer[i][j] = sc.nextInt();
                j++;
                entradasPlayer[i][j] = sc.nextInt();

                if ( entradasPlayer[i][j] < 0 || entradasPlayer[i][j] > 4 ) {
                    System.out.println( "Invalid coordinates. Choose different coordinates." );
                    contador--;
                    j--;
                    continue;
                }

                i++;
                j = 0;

            }

            //IMPRIMINDO O MAPA - i será as linhas do mapa
            for( i = 0; i < 5; i ++ ) {

                if( i == 0 ) System.out.println( "  0 1 2 3 4 " );
                System.out.print( i + " " );

                //j será as colunas do mapa
                for( j = 0; j < 5; j++ ) {

                    if( entradasPlayer[j][0] == i && entradasPlayer[j][1] == j ) {
                        System.out.print( "@ " );

                        //Gravando os mapas
                        if (contadorGeral == 0) mapa1[i][j] = '@';
                        if (contadorGeral == 1) mapa2[i][j] = '@';

                    }else {
                        System.out.print( "- " );

                        //Gravando os mapas
                        if (contadorGeral == 0) mapa1[i][j] = '-';
                        if (contadorGeral == 1) mapa2[i][j] = '-';
                    }

                }
                System.out.println(" "); //Quebrando linha

            }
            contadorGeral++;
        }



    }

}
