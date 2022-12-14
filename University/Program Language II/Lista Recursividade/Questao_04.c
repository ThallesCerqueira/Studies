#include <stdio.h>

int inverte(int *vet, int tam);

int main(){

    int vet[4] = {1,2,3,4};
    int tam = 4;

    inverte(vet, tam);


    return 0;
}

int inverte(int *vet, int tam){

    if(tam == 0){
        vet[0] = vet[0];
        return vet[0];
    }

    return vet[tam] = inverte(vet, tam - 1);


}