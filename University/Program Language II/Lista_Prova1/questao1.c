#include <stdio.h>
#include <stdlib.h>

void Cria_vetor(int **vetor, int tamanho);
void Preenche_vetor(int *vetor, int tamanho);
void Mostra_vetor_tela(int *vetor, int tamanho);
void Libera_memoria(int *vetor);

int main(){

    int *vetor;
    int tamanho;

    printf("Qual o tamanho do vetor que você deseja criar: ");
    scanf("%d", &tamanho);
    Cria_vetor(&vetor, tamanho);
    Preenche_vetor(vetor,tamanho);
    Mostra_vetor_tela(vetor, tamanho);
    Libera_memoria(vetor);

    return 0;
}

void Cria_vetor(int **vetor, int tamanho){
    *vetor = (int*)malloc(tamanho * sizeof(int));
}

void Preenche_vetor(int *vetor, int tamanho){
    for(int i = 0; i < tamanho; i++){
        printf("Entre com vetor[%i]: ", i);
        scanf("%i", &vetor[i]);
    }
}

void Mostra_vetor_tela(int *vetor, int tamanho){
    for(int i = 0; i < tamanho; i++){
        printf("Vetor[%d] = %i\n",i, vetor[i]);
    }
}

void Libera_memoria(int *vetor){
    free(vetor);
}
