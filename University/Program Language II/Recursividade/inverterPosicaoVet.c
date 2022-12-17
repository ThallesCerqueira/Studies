#include <stdio.h>

void inverte(int vet[], int inicio, int fim);
void imprimir(int vet[], int tam);

int main(){

    int vet[6] = {1,2,3,4,5,6};
    int tam = 6;

    imprimir(vet, tam);
    printf("\n");
    inverte(vet, 0, 5);
    imprimir(vet, tam);

    return 0;
}

void inverte(int vet[], int inicio, int fim){
    int aux;

    if(inicio < fim){
        aux = vet[inicio];
        vet[inicio] = vet[fim];
        vet[fim] = aux;

        inverte(vet, inicio +1, fim -1);
    }
}

void imprimir(int vet[], int tam){

    if(tam == 1){
        printf("%d\n", vet[tam-1]);
    }else{
        imprimir(vet, tam -1);
        printf("%d\n", vet[tam-1]);
    }




}