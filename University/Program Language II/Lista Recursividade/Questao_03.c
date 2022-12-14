#include <stdio.h>

void func(int *vet, int tam);

int main(){

    int vet[5] = {1,2,3,4,5};
    int tam = 5;

    func(vet, tam);

    return 0;
}

void func(int *vet, int tam){

    if(tam == 0){
        printf("%d\n", vet[tam]);
    }else{
        if(tam != 1){
            printf("%d\n", vet[tam-1]);
        }
        func(vet, tam - 1);
    }
}