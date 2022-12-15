#include <stdio.h>

void imprimirCrescente(int n);

int main(){

    int n;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    imprimirCrescente(n);

    return 0;
}

void imprimirCrescente(int n){

    if(n == 0){
        printf("%d\n", n);
    }else{
        imprimirCrescente(n-1);
        printf("%d\n", n);
    }
}