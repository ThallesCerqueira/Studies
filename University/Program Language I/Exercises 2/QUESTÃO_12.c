#include <stdio.h>

int main(){

    int aux = 0, resto, divisao, entrada;

    do{
        printf("Digite um inteiro positivo: ");
        scanf("%d", &entrada);

    }while(entrada < 0);

    while(entrada > 0){

        resto = entrada % 10;
        divisao = entrada / 10;
        entrada = divisao;

        if(resto == 7){
            aux++;
        }
    }

    printf("O quantidade de algarismos sete que aparecem é: %d\n", aux);

    return 0;
}