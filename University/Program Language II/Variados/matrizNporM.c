#include <stdio.h>
#include <stdlib.h>

int **alocaMatriz(int n, int m);
int **transposta(int **matriz, int n, int m);
void maior_valor(int **matriz, int n, int m);
void preencheMatriz(int **matriz, int n, int m);
void mostraMatriz(int **matriz, int n, int m);
void limpaTela();
void limpa_memoria(int **matriz, int n);

int main(){

    int **matr, n,m;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("Entre com o valor de m: ");
    scanf("%d", &m);

    matr = alocaMatriz(n,m);

    preencheMatriz(matr, n,m);

    limpaTela();
    printf("\n\nMATRIZ: \n");
    mostraMatriz(matr, n, m);

    
    matr = transposta(matr, n, m);

    
    printf("\nNova MATRIZ: \n");
    mostraMatriz(matr, n,m);

    maior_valor(matr, n, m);

    limpa_memoria(matr, n);
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

void preencheMatriz(int **matriz, int n, int m){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            printf("Entre com o elemento M[%i][%i]: ", i, j);
            scanf("%i", &matriz[i][j]);
        }
    }
}

void mostraMatriz(int **matriz, int n, int m){
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            printf("%i ", matriz[i][j]);
        }
        printf("\n");
    }
}

int **transposta(int **matriz, int n, int m){
    int **novaMatriz;
    novaMatriz = alocaMatriz(m,n);

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            novaMatriz[j][i] = matriz[i][j];
        }
    }

    return novaMatriz;
}

void limpaTela(){
    printf("\e[1;1H\e[2J");
}

void limpa_memoria(int **matriz, int n){
    
    for(int i = 0; i < 2; i++){
        free(matriz[i]);
    }

    free(matriz);
}

void maior_valor(int **matriz, int n, int m){
    int maior = INT_MIN;
    int ii, jj;
    int v[3];

    for(int a = 0; a < 3; a++){
        maior = INT_MIN;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matriz[i][j] > maior){
                    maior = matriz[i][j];
                    ii = i;
                    jj = j;
                }
            }
        }
        
        v[a] = maior;
        matriz[ii][jj] = 0;
    }

    printf("\n\nMaiores valores: \n");
    for(int i = 0; i < 3; i++){
        printf("%d\n",v[i]);
    }
}