#include <stdio.h>

float calcula(float n);

int main(){

    float resultado, n;

    printf("Entre com o valor de n: ");
    scanf("%f", &n);

    resultado = calcula(n);

    printf("O resultado é: %.3f\n", resultado);
    return 0;
}

float calcula(float n){

    if(n == 1){
        return 1;
    }else{
        return 1 + 1/calcula(n-1);
    }
}

