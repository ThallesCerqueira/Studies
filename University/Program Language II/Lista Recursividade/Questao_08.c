#include <stdio.h>

float soma(int n);

int main(){

    int n;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("O resultado é: %.2f\n", soma(n));

    return 0;
}

float soma(int n){

    if(n == 1){
        return ((n*n + 1.0)/(n+3));
    }else{
        return ((n*n + 1.0)/(n+3)) + soma(n-1);
    }

}