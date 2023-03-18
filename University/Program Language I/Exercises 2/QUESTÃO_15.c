#include <stdio.h>

int main(){

    int entrada, proximo, ultimo = 1, atual = 1;

    do{
        printf("DIGITE O TERMO DESEJADO DA SEQUÊNCIA DE FIBONNACI: ");
        scanf("%d", &entrada);

        if(entrada < 0){

            printf("Digite um termo válido (Maior que 1)\n\n");
        }

    }while(entrada < 0);

    for(int contador = 0; contador <= entrada - 3; contador++){
        
        proximo = ultimo + atual; 
        ultimo = atual;
        atual = proximo;

    }

    printf("O termo %d da Sequência de Fibonacci é %d\n\n", entrada, proximo);

    return 0;
}