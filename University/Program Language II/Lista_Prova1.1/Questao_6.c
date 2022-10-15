#include <stdio.h>

void func(int *ponteiroX, int *ponteiroY);

int main(){

    int x, y, *ponteiroX, *ponteiroY;

    ponteiroX = &x;
    ponteiroY = &y;

    //Input dos valores
    printf("Entre com o valor de X: ");
    scanf("%i", &x);
    printf("Entre com o valor de Y: ");
    scanf("%i", &y);

    //Chamada da funcao func
    func(ponteiroX, ponteiroY);

    printf("Soma de X e Y: %i\n", x);
    printf("Diferença entre X e Y: %i\n", y);

    return 0;
}

void func(int *ponteiroX, int *ponteiroY){
    int aux = (*ponteiroX) - (*ponteiroY);
    *ponteiroX += *ponteiroY;
    *ponteiroY = aux;
}