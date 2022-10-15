#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void lerVetor(int *vetor, int tamanho);
void mm(int *vetor, int tamanho, int *maximo, int *minimo);

int main(){

    //Declaração das variáveis
    int *vetor, tamanho, *maximo, *minimo, max, min;
    maximo = &max;
    minimo = &min;

    //Input para tamanho do vetor
    printf("Qual o tamanho do vetor? ");
    scanf("%i", &tamanho);

    //Alocação para vetor
    vetor = (int*) malloc(tamanho * sizeof(int));

    //chamada da função lerVetor
    lerVetor(vetor, tamanho);

    //chamada da função mm
    mm(vetor, tamanho, maximo, minimo);

    //Output do máximo e mínimo
    printf("O valor máximo do vetor é: %i\n", *maximo);
    printf("O valor mínimo do vetor é: %i\n", *minimo);


    return 0;
}

void lerVetor(int *vetor, int tamanho){
    //Leitura dos valores do vetor
    for(int i = 0; i < tamanho; i++){
        printf("Informe o valor de Vetor[%i]: ", i);
        scanf("%i", &vetor[i]);
    }
}

void mm(int *vetor, int tamanho, int *maximo, int *minimo){

    //Inicialização de variáveis auxiliares
    *maximo = INT_MIN;
    *minimo = INT_MAX;

    //Verificação do maior e menor
    for(int i = 0; i < tamanho; i++){
        if(vetor[i] > *maximo){
            *maximo = vetor[i];
        }
        if(vetor[i] < *minimo){
            *minimo = vetor[i];
        }
    }
}