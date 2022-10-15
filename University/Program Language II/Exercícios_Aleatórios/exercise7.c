#include <stdio.h>
#include <stdlib.h>

int main(){

    int **M, m, n;
    m = 4;
    n = 4;
  
    M = malloc(m * sizeof(int));

    //Criação dos espaços na memoria
    for(int i = 0; i < m; i++){
        M[i] = (int*) malloc(n * sizeof(int));
    }

    //leitura dos valores
    for(int i = 0; i < m; i++){
        for(int j = 0; j < m; j++){
            printf("Digite M[%d][%d]: ", i, j);
            scanf("%d", &M[i][j]);
        }
    }

    //Output da matriz
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            printf("M[%d][%d] = %d\n", i,j, M[i][j]);
        }
    }

    //liberando espaço da memoria
    for(int i = 0; i < m; i++){
       free(M[i]);

    }

    free(M);

    return 0;
}