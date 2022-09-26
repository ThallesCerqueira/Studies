#include <stdio.h>

//declaração da função
int contatenarFunction(int *Vet1, int *Vet2, int tam1, int tam2);

int main(){

    //declaração das variaveis
    int *Vet1, *Vet2, *Vet3, tam1, tam2;

    //Output/Input

    printf("Entre com o tamanho do vetor 1: ");
    scanf("%d", &tam1);

    printf("Entre com o tamanho do vetor 1: ");
    scanf("%d", &tam2);

    //alocaçao da memoria
    Vet1 = (int*)malloc(tam1 * sizeof(int));
    Vet2 = (int*)malloc(tam2 * sizeof(int));

    return 0;
}


//Incompleta