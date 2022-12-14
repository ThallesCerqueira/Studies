#include <stdio.h>

float Mult(int a, float b);

int main(){

    float resultado, multiplicando;
    int multiplicador;

    printf("Entre com o multiplicador: ");
    scanf("%d", &multiplicador);

    printf("Entre com o multiplicando: ");
    scanf("%f", &multiplicando);

    resultado = Mult(multiplicador, multiplicando);

    printf("\n%d x %.2f = %.2f\n", multiplicador, multiplicando, resultado);
    
    return 0;
}

float Mult(int a, float b){

    if(a == 1){
        return b;
    }else{
        return b + Mult(a - 1, b);
    }
}