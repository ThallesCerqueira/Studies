#include <stdio.h>

int main(){

    //Declarando as variáveis
    int valor1, valor2;

    //Input dos valores
    printf("Por gentileza digite dois números inteiros:\n");
    scanf("%i", &valor1);
    scanf(" %i", &valor2);

    //Estrutura condicional
    valor1 > valor2 ? printf("%i é o maior\n", valor1):
     valor2 > valor1 ? printf("%i é o maior\n", valor2): printf("Estes números são iguais\n");

    return 0;
}