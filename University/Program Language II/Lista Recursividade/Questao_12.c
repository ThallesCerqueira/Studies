#include <stdio.h>

int menorVet(int vet[], int tam);

int main(){

    int vet[3], menor, tam;
    tam = 3;

    printf("Entre com V[0]: ");
    scanf("%d", &vet[0]);

    printf("Entre com V[1]: ");
    scanf("%d", &vet[1]);

    printf("Entre com V[2]: ");
    scanf("%d", &vet[2]);

    menor = menorVet(vet, tam);

    printf("O menor valor é: %d\n", menor);

    return 0;
}

int menorVet(int vet[], int tam){

    if(tam == 0){
        return vet[0];
    }else{
        if(vet[tam] < menorVet(vet, tam-1)){
            return vet[tam];
        }else{
            menorVet(vet, tam -1);
        }
    }
}