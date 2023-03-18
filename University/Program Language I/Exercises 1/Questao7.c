#include <stdio.h>

int main(){

    //Declaração das variáveis
    float raio, diametro, circunferencia, pi, area;

    //Input do raio
    printf("Digite o raio do círculo: \n");
    scanf("%f", &raio);

    //Declaração dos valores pertinentes às variáveis
    pi = 3.1415;
    diametro = raio * 2;
    circunferencia = 2 * pi * raio;
    area = pi * (raio * raio);

    //Output dos valores
    printf("\nCaracterísticas do círculo --\n\nDiâmetro: %.2f u.a\nCircunferência: %.2f u.a\nÁrea: %.2f u.a\n", diametro, circunferencia, area);

    return 0;
}