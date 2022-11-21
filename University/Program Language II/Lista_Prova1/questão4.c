#include <stdio.h>

int* maximo(float *vetor, int tamanho);

int main(){

    //Declarações
    int tamanho;
    float *vetor, *memoria;

    //Inicializações
    tamanho = 5;

    //Alocação de memória para Vetor
    vetor = (float*) malloc(tamanho * sizeof(float));

    //Preenchimento vetor
    for(int i = 0; i < tamanho; i++){
        printf("Entre com V[%i]: ", i);
        scanf("%f", &vetor[i]);
    }

    //Recebimento do endereço do maior valor dentro de Vetor
    memoria = maximo(vetor, tamanho);

    printf("Memoria = %p\n", memoria);

    return 0;
}

int* maximo(float *vetor, int tamanho){

    //variavel auxiliar
    float aux, *aux2;
    aux = vetor[0];

    //percorrendo todo vetor e verificando o maior
    for(int i = 0; i < tamanho; i++){
        if(vetor[i] > aux){
            aux2 = &vetor[i];
        }
    }

    return aux2;
}