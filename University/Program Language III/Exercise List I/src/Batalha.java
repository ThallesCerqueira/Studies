import java.util.Scanner;

public class Batalha {

    public static void main(String[] args) {

        int linhas, colunas;
        linhas = colunas = 5;
        char[][] mapa1 = new char[5][5];
        char[][] mapa2 = new char[5][5];
        char[][] mapaCopia1 = new char[5][5];
        char[][] mapaCopia2 = new char[5][5];

        //Preenchimento padrão dos mapas
        for(int i = 0; i < 5; i++ ){
            for (int j = 0; j < 5; j++){
                mapa1[i][j] = '-';
                mapa2[i][j] = '-';
                mapaCopia1[i][j] = '-';
                mapaCopia2[i][j] = '-';
            }
        }

        System.out.println( "Welcome to battleship!!!\n" );

        //Escolhendo as posicoes dos navios PLAYER 1
        escolhePosicoes( mapa1, 1 );

        //Mostrando MAPA PLAYER 1
        mostraMapa( mapa1, linhas, colunas );

        //Escolhendo as posicoes dos navios PLAYER 2
        escolhePosicoes( mapa2, 2 );

        //Mostrando MAPA PLAYER 2
        mostraMapa( mapa2, linhas, colunas );

        do{
            //Ataque PLAYER 1
            ataque( mapa2, mapaCopia2, 1, 2 );

            // Verifica se ainda há navios no mapa
            if( !verificaNavios( mapa2, linhas, colunas ) ) {
                System.out.println( "PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!" );
                break;
            }

            //Ataque PLAYER 2
            ataque( mapa1, mapaCopia1, 2, 1);

            //Verifica se ainda há navios no mapa
            if( !verificaNavios( mapa1, linhas, colunas ) ) {
                System.out.println( "PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!" );
                break;
            }

        }while (true);

        System.out.println( "\nFinal boards: " );
        System.out.println( " " );
        mostraMapa( mapa1, linhas, colunas );
        System.out.println( " " );
        mostraMapa( mapa2, linhas, colunas );
        System.out.println( " " );

    }

    public static void escolhePosicoes(char[][]mapa, int player){

        Scanner sc = new Scanner( System.in );
        int auxiliarX;
        int auxiliarY;

        System.out.println( "PLAYER " + player + ", ENTER YOUR SHIP'S COORDINATES" );

        for(int i = 0; i < 5; i++){

            System.out.println( "Enter your " + (i + 1) + " location: " );

            //leitura de x e y
            auxiliarX = sc.nextInt();
            auxiliarY = sc.nextInt();

            if ( auxiliarX < 0 || auxiliarX > 4 || auxiliarY < 0 || auxiliarY > 4 ) {
                System.out.println( "Invalid coordinates. Choose different coordinates." );
                i--;
                continue;
            } else if ( mapa[auxiliarX][auxiliarY] == '@' ) {
                System.out.println( "You already have a ship there. Choose different coordinates" );
                i--;
                continue;
            }

            mapa[auxiliarX][auxiliarY] = '@';
        }
    }

    public static void mostraMapa( char mapa[][], int linhas, int colunas ){

        System.out.println( "  0 1 2 3 4" );
        for ( int i = 0; i < linhas; i++ ){
            System.out.print(i + " ");
            for(int j = 0; j < colunas; j++){
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void ataque( char[][] defesa, char[][] defesaCopia, int playerAtacante, int playerDefesa ) { // Tentativa de generalização do codigo

        Scanner sc = new Scanner( System.in );
        int auxiliarX;
        int auxiliarY;

        do{
            System.out.println( "Player " + playerAtacante + ", enter hit row/column:" );
            auxiliarX = sc.nextInt();
            auxiliarY = sc.nextInt();

            if ( auxiliarX < 0 || auxiliarX > 4 || auxiliarY < 0 || auxiliarY > 4 ) { // Verificando validade do tiro
                System.out.println("Invalid coordinates. Choose different coordinates.");

            } else if ( defesa[auxiliarX][auxiliarY] == 'X' || defesa[auxiliarX][auxiliarY] == 'O') { // Verificando se já houve tiro no local

                System.out.println( "You already fired on this spot. Choose different coordinates." );

            } else if ( defesa[auxiliarX][auxiliarY] == '-' ) { // Verificando local que não sofreu tiro

                System.out.println( "Player " + playerAtacante + " MISSED!" );
                defesa[auxiliarX][auxiliarY] = 'O';
                defesaCopia[auxiliarX][auxiliarY] = 'O';
                mostraMapa( defesaCopia, 5, 5 );
                break;

            } else if ( defesa[auxiliarX][auxiliarY] == '@' ) { // Verificando se no local há um navio

                System.out.println( "Player "+ playerAtacante + " hit Player " + playerDefesa + "’s Ship!!!" );
                defesa[auxiliarX][auxiliarY] = 'X';
                defesaCopia[auxiliarX][auxiliarY] = 'X';
                mostraMapa( defesaCopia, 5, 5 );
                break;
            }

        }while (true);
    }

    public static boolean verificaNavios( char [][]mapa, int linhas, int colunas ) {

        for (int i = 0; i < linhas; i++){
            for( int j = 0; j < colunas; j++){
                if( mapa[i][j] == '@') return true;
            }
        }

        return false;

    }

}