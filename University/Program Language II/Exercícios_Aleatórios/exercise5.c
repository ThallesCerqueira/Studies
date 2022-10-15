#include <stdio.h>
#include <stdlib.h>

int main(){

    int qtd;
    float *p, media;
    media = 0;

    printf("Entre com a quantidade de Notas: ");
    scanf("%i", &qtd);

    p = (float*)malloc(qtd * sizeof(float));

    for(int i = 0; i < qtd; i++){
        printf("Entre com a %i nota: ", i+1);
        scanf("%f", &p[i]);
        media += (p[i]/qtd);
    }

    for(int i = 0; i < qtd; i++){

        if(p[i] < 7){
            printf("Nota abaixo da média: %f\n", p[i]);
        }

    }
    return 0;
}