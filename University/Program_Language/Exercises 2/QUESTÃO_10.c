#include <stdio.h>

int main(){

    int entrada, aux, inverso = 0;

    printf("Digite um número para verificação: ");
    scanf("%i", &entrada);

    aux = entrada; 

    while(aux > 0){

        inverso = (inverso * 10) + (aux % 10);
        aux = aux / 10;
    }

    if(inverso == entrada){

        printf("O número digitado é um palindromo\n\n");
    }else{

        printf("O número digitado não é um palindromo\n\n");

    }



    return 0;
}