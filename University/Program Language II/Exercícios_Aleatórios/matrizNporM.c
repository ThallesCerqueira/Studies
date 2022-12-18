#include <stdio.h>

int **alocaMatriz(int n, int m);

int main(){

    int **matr, n,m;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("Entre com o valor de m: ");
    scanf("%d", &m);

    matr = alocaMatriz(n,m);

    return 0;
}

int **alocaMatriz(int n, int m){
    int **matriz;

    matriz = (int**)malloc(n * sizeof(int*));

    for(int i = 0; i < m; i++){
        matriz[i] = (int*)malloc(m * sizeof(int));
    }

    return matriz;
}