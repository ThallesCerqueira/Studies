#include <stdio.h>

int mostraVet(int vet[], int tam);

int main(){

    int vet[3];

    for(int i = 0; i < 3; i++){
        printf("Entre com Vet[%d]: ", i);
        scanf("%d", &vet[i]);
    }

    mostraVet(vet, 3);

    return 0;
}

int mostraVet(int vet[], int tam){

    if(tam - 1 == 0){
        printf("VET[%d]: %d\n", tam - 1, vet[tam - 1]);
        return;
    }

    printf("VET[%d]: %d\n", tam - 1, vet[tam - 1]);
    return mostraVet(vet, tam - 1);

}