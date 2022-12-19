#include <stdio.h>

int soma(int *v, int tam);

int main(){

    int v[4] = {7,2,3,4};

    printf("O resultado é: %d\n", soma(v,4));

    return 0;
}

int soma(int *v, int tam){

    if(tam == 1){
        return v[tam-1];
    }else{
        return v[tam-1] + soma(v, tam -1);
    }
}