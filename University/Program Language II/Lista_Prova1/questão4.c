#include <stdio.h>

int* maximo(int *vetor, int tamanho);

int main(){

    //Declarações
    int tamanho, *vetor, *memoria;

    //Inicializações
    tamanho = 5;

    //Alocação de memória para Vetor
    vetor = (int*) malloc(tamanho * sizeof(int));

    //Preenchimento vetor
    for(int i = 0; i < tamanho; i++){
        vetor[i] = i;
    }

    //Recebimento do endereço do maior valor dentro de Vetor
    memoria = maximo(vetor, tamanho);

    printf("Memoria = %i\n", memoria);

    return 0;
}

int* maximo(int *vetor, int tamanho){

    //variavel auxiliar
    int *aux;
    aux = vetor[0];

    //percorrendo todo vetor e verificando o maior
    for(int i = 0; i < tamanho; i++){
        if(vetor[i] > aux){
            aux = vetor[i];
        }
    }

    return aux;

}