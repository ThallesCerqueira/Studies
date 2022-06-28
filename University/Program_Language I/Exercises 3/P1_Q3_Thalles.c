#include <stdio.h>
#include <limits.h>

int main(){

    int quantidade, entrada, maior, menor;
    maior = INT_MIN;
    menor = INT_MAX;

    do{

        printf("Digite a quantidade de números a serem analisados: ");
        scanf("%d", &quantidade);

    }while(quantidade <= 0);

    for(int contador = 1; contador <= quantidade; contador++){

        scanf("%d", &entrada);

        if(entrada > maior){
            maior = entrada;
        }
        if(entrada < menor){
            menor = entrada;
        }
    }

    printf("O maior valor é: %d\n", maior);
    printf("O menor valor é: %d\n", menor);

    return 0;
}