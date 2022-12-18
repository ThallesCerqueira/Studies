#include <stdio.h>

float soma(int n);

int main(){

    int n;

    printf("Informe o valor de n: ");
    scanf("%d", &n);

    printf("O resultado é: %.2f\n", soma(n));

    return 0;
}

float soma(int n){
    if(n == 1){
        return 1.0;
    }else{
        return 1.0/n + soma(n-1);
    }
}