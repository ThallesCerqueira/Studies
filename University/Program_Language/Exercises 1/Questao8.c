#include <stdio.h>

int main(){

    //Declaração das variáveis
    int x, y;

    //Input das coordenadas
    printf("Informe as coordenadas x e y do ponto A no plano cartesiano, respectivamente:\n");
    scanf("%i", &x);
    scanf(" %i", &y);

    //Estrutura condicional
    x > 0 && y > 0 ? printf("O ponto A está no Primeiro Quadrante\n"):
     x < 0 && y > 0 ? printf("O ponto A está no Segundo Quadrante\n"):
      x < 0 && y < 0 ? printf("O ponto A está no Terceiro Quadrante\n"):
       x > 0 && y < 0 ? printf("O ponto A está no Quarto Quadrante\n"):
        printf("O ponto A está sobre um dos eixos.\n");
         
    return 0;
}