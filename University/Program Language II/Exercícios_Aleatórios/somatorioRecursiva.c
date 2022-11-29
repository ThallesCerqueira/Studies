#include <stdio.h>
#include <stdlib.h>

int somatorioMatriz(int *matriz, int i);

int main(){

    int resultado;

    int *matriz;

    matriz = (int*) malloc(sizeof(int) * 4);

    for(int i = 0; i < 4; i ++){
        printf("Entre com Matriz[%d]: ", i);
        scanf("%d", &matriz[i]);
    };

    resultado = somatorioMatriz(matriz, 4);

    printf("O somatório é: %d\n", resultado);


    return 0;
}

int somatorioMatriz(int *matriz, int i){
    int resultado = 0;

    if(i == 0 ){
        return matriz[i];
    }else{
        resultado = matriz[i] + somatorioMatriz(matriz, i-1);
    }
    return resultado;
}