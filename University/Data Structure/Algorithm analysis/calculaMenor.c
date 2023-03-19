/*
    Estes exemplos abaixo são exemplos que estão no Livro 
        "Estrutura de dados: algoritmos, análise da complexidade e implementações em JAVA e C/C++"
*/

#include <stdio.h>

int calculaMenor( int *vet, int tamVet );

int main() {

    int i, menor, tamVet, vet[5];
    tamVet = 5;

    for( i = 0; i < 5; i++){
        printf("Entre com o valor de Vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }

    menor = calculaMenor( vet, tamVet );

    printf("O menor no vetor é: %d", menor);


}

int calculaMenor( int *vet, int tamVet ){

    int i, menor;
    
    menor = vet[0];

    for( i = 0; i < tamVet; i++){

        if(vet[i] < menor) {
            menor = vet[i];
        }

    }

    return menor;

}