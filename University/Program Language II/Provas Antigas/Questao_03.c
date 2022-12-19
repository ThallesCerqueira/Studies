#include <stdio.h>

int contador(int *v, int tam);

int main(){

    int v[4] = {3,43,63,3};

    printf("A quantidade de pares é: %d\n", contador(v,4));

    return 0;
}

int contador(int *v, int tam){

    if(tam == 1){
        if(v[tam-1] % 2 == 0){
            return 1;
        }
    }else{
        if(v[tam - 1] % 2 == 0){
            return 1 + contador(v, tam -1);
        }else{
            return contador(v, tam -1);
        }
    }
}