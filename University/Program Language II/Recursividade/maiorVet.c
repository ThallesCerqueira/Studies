#include <stdio.h>

int maior(int v[], int tam, int indice);

int main(){

    int vet[10] = {7,10,9};
    int tam = 3;

    printf("O maior é: %d\n", maior(vet, tam, 0));

    return 0;
}

int maior(int v[], int tam, int indice){

    if(tam == 0){
        return v[indice];
    }else{
        if(v[tam - 1] > v[indice]){
            return maior(v, tam -1, tam-1);
        }else{
            return maior(v, tam -1, indice);
        }
    }

}