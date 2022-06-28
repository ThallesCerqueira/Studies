#include <stdio.h>

int main(){

    //Declaração variável sem sinal
    unsigned int valor, soma;

    //Input do valor
    printf("Por gentileza, informe um número inteiro:\n");
    scanf("%i", &valor);

    //Fórmula para soma do intervalo
    soma = valor * (valor + 1) / 2;

    //Output do resultado
    printf("A soma dos valores de 0 até %i é: %i\n", valor, soma);

    return 0;
}