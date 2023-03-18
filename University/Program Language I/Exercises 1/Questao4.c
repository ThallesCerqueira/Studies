#include <stdio.h>

int main(){

    //Declaração da variável
    int valor;

    //Input de valor
    printf("Por gentileza digite um número inteiro:\n");
    scanf("%i", &valor);

    //Operador condicional
    valor % 2 == 0 ? printf("%i é par\n", valor): printf("%i é ímpar\n", valor);

    return 0;
}