#include <stdio.h>
#include <stdlib.h>

int* uniao(int *A, int n, int *B, int m, int *C);
void preencher_vetor(int *A, int n, int *B, int m);
int* verifica_duplicidade(int *C, int tamanho);
int* remove_valor(int *C, int tamanho, int posicao);

int tamanhoC = 0;

int main(){

    int *A; 
    int *B; 
    int *C, n, m;

    n = 3;
    m = 3;

    A = (int*) malloc(n * sizeof(int));
    B = (int*) malloc(m * sizeof(int));

    preencher_vetor(A, n, B, m);
    C = uniao(A, n, B, m, C);

    C = verifica_duplicidade(C, tamanhoC);

    printf("Novo vetor, sem duplicidades: \n");
    for(int i = 0; i < tamanhoC; i++){
        printf("C[%d]: %d\n", i, C[i]);
    }

    printf("Tamanho: %d\n", tamanhoC);

    return 0;
}

void preencher_vetor(int *A, int n, int *B, int m){
    
    for(int i = 0; i < n; i++){
        printf("Entre com A[%d]: ", i);
        scanf("%d", &A[i]);
    }
    
    for(int i = 0; i < m; i++){
        printf("Entre com B[%d]: ", i);
        scanf("%d", &B[i]);
    }

}

int* uniao(int *A, int n, int *B, int m, int *C){
    
    tamanhoC = n + m;

    C = (int*) malloc(tamanhoC * sizeof(int));

    for(int i = 0; i < n; i++){
        C[i] = A[i];
    }

    for(int i = 0;i < m; i++){
        C[i + n] = B[i];
    }
    
    return C;
}

int* verifica_duplicidade(int *C, int tamanho){
    int aux = C[0];
    //verificando igualdade
    for(int i = 0; i < tamanho; i++){
        for(int j = (i+1); j < tamanho; j++){
            if(C[i] == C[j]){
                C = remove_valor(C, tamanho, j);
                tamanhoC--;
            }
        }
    }

    return C;
}

int* remove_valor(int *C, int tamanho, int posicao){
    
    //transposicao dos valores
    for(int i = posicao; i < tamanho; i++){
        C[i] = C[i+1];
    }

    //realocacao de memoria para Vetor
    C = (int*) realloc(C, tamanho-1); 
    return C;
}