#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int ***alocaMatriz();
void preenche_matriz(int ***matriz);
int maior_valor(int ***matriz);
void ***limpa_memoria(int ***matriz);
void mostra_matriz(int ***matriz);

int main(){

    int ***matriz, maior;

    matriz = alocaMatriz();
    preenche_matriz(matriz);
    mostra_matriz(matriz);
    maior = maior_valor(matriz);
    printf("%d é o maior!\n", maior);

    limpa_memoria(matriz);
    
    return 0;
}

int ***alocaMatriz(){
    
    int ***matriz;

    matriz = (int***)malloc(2 * sizeof(int**));
    matriz[0] = (int**)malloc(2* sizeof(int*));
    matriz[1] = (int**)malloc(2* sizeof(int*));
    matriz[0][0] = (int*)malloc(2 * sizeof(int));
    matriz[0][1] = (int*)malloc(2 * sizeof(int));
    matriz[1][0] = (int*)malloc(2 * sizeof(int));
    matriz[1][1] = (int*)malloc(2 * sizeof(int));

    return matriz;

}

void preenche_matriz(int ***matriz){
    
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 2; k++){
                printf("Entre com o elemento M[%i][%i][%i]: ", i, j, k);
                scanf("%i", &matriz[i][j][k]);
            }
        }
    }
}

int maior_valor(int ***matriz){
    
    int maior = INT_MIN;
    
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 2; k++){
                if(matriz[i][j][k] > maior){
                    maior = matriz[i][j][k];
                }
            }
        }
    }
    
    return maior;
}

void ***limpa_memoria(int ***matriz){
    
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            free(matriz[i][j]);
        }
    }

    free(matriz);
}

void mostra_matriz(int ***matriz){
    
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 2; k++){
                printf("Elemento M[%i][%i][%i]: %i\n",i, j, k, matriz[i][j][k]);
            }
        }
    }
}