#include <stdio.h>

int main(){

    float media, notas[5], aux;
    media = 0;

    printf("Bem vindo, venha calcular sua média no Semestre (Limitado a 5 créditos)!\n");
    
    for(int i = 0; i < 5; i++){

        printf("Entre com %dº crédito: ", i+1);
        scanf("%f", &aux);

        if(aux >= 0 & aux <= 10) notas[i] = aux;
        else notas[i] = 0;

        media += notas[i];

    }

    media /= 5;

    for(int i = 0; i < 5; i++){
        printf("\nNota do %dº crédito: %f\n", i+1, notas[i]);
    }

    printf("\nE sua média foi: %f\n", media);

    return 0;
}