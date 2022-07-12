#include <stdio.h>

int main(){

    float notas[2][4];
    float medias[2] = {0,0};

    printf("Bem vindo, vamos calcular suas médias?\n");

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 4; j++){
            printf("Entre com %iº crédito do %iº semestre: ", j+1, i+1);
            scanf("%f", &notas[i][j]);
            medias[i] += (notas[i][j] / 4); 
        }
        printf("\n\n");
    }

    for(int i = 0; i< 2; i++){
        for(int j = 0; j < 4; j++){
            printf("%iº crédito do %iº semestre: %f\n", j+1, i+1, notas[i][j]);
        }
        printf("\nSua média do %i Semestre foi: %f\n\n", i+1, medias[i]);
    }


    return 0;
}