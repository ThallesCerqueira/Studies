#include <stdio.h>

float media(int v[], int tam, int qtd);

int main(){

    int v[] = {1,2,3,4, 5};
    int tam = 4;
    int qtd = 5;

    printf("A média é: %.2f", media(v, tam, qtd));

    return 0;
}

float media(int v[], int tam, int qtd){
    if(tam == 0){
        return v[tam]/(qtd * 1.0);
    }else{
        return (v[tam] / (qtd * 1.0)) + media(v, tam -1, qtd);
    }
}