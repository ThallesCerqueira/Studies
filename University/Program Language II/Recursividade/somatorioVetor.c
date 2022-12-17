#include <stdio.h>

int somaVet(int v[], int tam); 

int main(){

    int vet[10] = {1,2,3,4,5,6,7,8,9,10};
    int tam = 10;

    printf("A soma é: %d\n", somaVet(vet, tam));



    return 0;
}

int somaVet(int v[], int tam){
    if(tam == 0){
        return 0;
    }else{
        return v[tam-1] + somaVet(v, tam -1);
    }
}