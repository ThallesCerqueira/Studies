/*
    Bom, aparentemente este algoritmo é fácil de análisar, digo ser complexidade de n, pois é um simples
    somatório até N.
*/

#include <stdio.h>

int somaN( int n );

int main() {

    int n, resposta;
    
    printf( "Entre com o valor de n: " );
    scanf( "%d", &n );

    resposta = somaN( n );

    printf( "\nResposta: %d\n\n", resposta );

    return 0;

}

int somaN( int n ) {

    if(n == 1) {

        return 1;
        
    }else {

        return n + somaN( n-1 );

    }

}