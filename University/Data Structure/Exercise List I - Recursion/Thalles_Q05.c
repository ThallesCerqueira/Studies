#include <stdio.h>
#include <stdlib.h>

int* randArray( int n, int a, int b );

int vetMax( int *vet, int n ); // Complexidade n

int vetSoma( int *vet, int n ); // Complexidade n

int ValInVet( int val, int *vet, int n ); // Complexidade n

int posValVet( int val, int *vet, int n ); // Complexidade n

int main() {

    int *vet, max, soma, tam, contem, valProcurar, pos;

    vet = randArray( 10, 10, 20 );
    tam = 5;
    valProcurar = 4;

    //Alternativa a
    max = vetMax( vet, tam - 1 );
    printf("Maior valor do Array = %d\n", max);

    //Alternativa b
    soma = vetSoma( vet, tam - 1 );
    printf( "Soma dos valores do Array = %d\n\n", soma );

    //Alternativa c
    contem = ValInVet( valProcurar, vet, tam - 1 );
    if( contem == valProcurar ) {

        printf("Valor %d está contido no Vetor.\n\n", valProcurar);

    }else {

        printf("Valor %d não está contido no Vetor.\n\n", valProcurar);

    }

    //Alternativa d
    pos = posValVet( valProcurar, vet, tam - 1 );
    printf( "O valor %d está na %dº posição.\n\n", valProcurar, pos );

    return 0;

}

int* randArray( int n, int a, int b ) {

    int *vet = ( int* ) malloc( n * sizeof( int ) );

    for( int i = 0; i < n; i++ ) {

        vet[i] = a + rand() % ( b - a + 1);

    }

    return vet;

}

int vetMax( int *vet, int n ) {

    if( n == 0 ) {

        return vet[0];

    }else {

        if( vet[n] > vetMax( vet, n-1 ) ) {

            return vet[n];

        }else{
            vetMax( vet, n - 1 );
        }

    }

}

int vetSoma( int *vet, int n ) {

    if( n == 0 ) {
        
        return vet[0];

    }else {

        return vet[n] + vetSoma( vet, n - 1 );

    }

}

int ValInVet( int val, int *vet, int n ) { 

    if( n == 0 ) {

        return vet[0];

    }else {

        if( vet[n] == val ) {

            return vet[n];

        }else {

            ValInVet( val, vet, n - 1 );

        }

    }

}

int posValVet( int val, int *vet, int n ) {

    if( n == 0 ) {

        if( vet[n] == val ) return n;

    }else {

        if( vet[n] == val ) {

            return n;

        }else {

            posValVet( val, vet, n - 1 );

        }

    }

}