#include <stdio.h>

int main(void){

    //Opção a
    int a, b, c;

    //Opção b
    printf("Bem-Vindo!\nDigite por gentileza dois valores inteiros:\n");
    scanf("%d", &a);
    scanf("%d", &b);


    //Opção c
    c = a + b;
    printf("\nA soma entre %d e %d é: %d\n\n", a, b, c);

    //Opção d
    c = a * b;
    printf("O resultado do produto entre %d e %d é: %d\n\n", a, b, c);

    //Opção e
    c = a - b;
    c > 0? printf("A diferença entre %d e %d é: %d\n\n", a, b, c): printf("A diferença entre %d e %d é: %d\n\n", a, b, -c);

    //Opção f
    c = a / b;
    printf("A divisão inteira entre %d e %d é: %d\n\n", a, b, c);

    //Opção g
    c = a % b;
    printf("O resto da divisão entre %d e %d é: %d\n\n", a, b, c);

    return 0;
}