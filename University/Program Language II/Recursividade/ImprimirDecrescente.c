#include <stdio.h>

void imprimirDecrescente(int n);

int main(){

    int n;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    imprimirDecrescente(n);

    return 0;
}

void imprimirDecrescente(int n){

    if(n == 1){
        printf("%d\n", n);
    }else{
        printf("%d\n", n);
        imprimirDecrescente(n-1);
    }
}