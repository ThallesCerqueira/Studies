#include <stdio.h>
#include <stdlib.h>

int **aloca_matriz(int m, int n);
void mostra_matriz(int **matriz, int m, int n);
void libera_memoria(int **matriz, int m);

int main(){

    int m, n, **matriz;

    printf("Entre com o número de linhas da matriz: ");
    scanf("%i", &m);

    printf("Entre com o número de colunas da matriz: ");
    scanf("%i", &n);

    matriz = aloca_matriz(m, n);

    //leitura dos valores
    for(int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            printf("Entre com Matriz[%i][%i]: ", i, j);
            scanf("%i", &matriz[i][j]);
        }
    }

    //mostra matriz
    mostra_matriz(matriz, m, n);

    //libera memoria
    libera_memoria(matriz, m);
    
    return 0;
}

int **aloca_matriz(int m, int n){ 
    int **matriz;

    matriz = (int**) malloc(m * sizeof(int*));
    for(int i = 0; i < m; i++){
        matriz[i] = (int*) malloc(n * sizeof(int));
    }
    return matriz;
}

void mostra_matriz(int **matriz, int m, int n){
    for(int i = 0; i < m; i++){
        for (int j = 0; j < n; j++){
            printf("Matriz[%i][%i] = %i\n",i, j, matriz[i][j]);
        }
    }
}

void libera_memoria(int **matriz, int m){
    for(int i = 0; i < m; i++){
        free(matriz[i]);
    }
    free(matriz);
}