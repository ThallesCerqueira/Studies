#include <stdio.h>
#include <stdlib.h>

void preenche_vetor(int *vetor, int tamanho);
int verifica_duplicidade(int *vetor, int tamanho);
int remove_valor(int *vetor, int tamanho, int posicao);
void print_vetor(int *vetor, int tamanho);

int main(){

    //Declarações
    int *vetor, tamanho;

    //Input do tamanho do vetor
    printf("Entre com o tamanho do vetor: ");
    scanf("%d", &tamanho);

    //Alocação da memória
    vetor = (int*) malloc(tamanho * sizeof(int));

    //Chamada da funcao preencher_vetor
    preenche_vetor(vetor, tamanho);

    //Chamada da funcao verifica_duplicidade
    tamanho = verifica_duplicidade(vetor, tamanho);

    //Chamada da funcao print_vetor
    print_vetor(vetor, tamanho);


    return 0;
}

void preenche_vetor(int *vetor, int tamanho){

    //Preenchimento do vetor
    for(int i = 0; i < tamanho; i++){
        printf("Entre com Vetor[%d]: ", i);
        scanf("%d", &vetor[i]);
    }
}

int verifica_duplicidade(int *vetor, int tamanho){
    //variavel auxiliar
    int aux = vetor[0];
    
    //verificando igualdade
    for(int i = 0; i < tamanho; i++){
        for(int j = (i+1); j < tamanho; j++){
            if(vetor[i] == vetor[j]){
                //Até aqui está ok
                //chamada da funcao remove_valor
                tamanho = remove_valor(vetor, tamanho, j);
            }
        }
    }

    return tamanho;
}

int remove_valor(int *vetor, int tamanho, int posicao){
    
    //transposicao dos valores
    for(int i = posicao; i < tamanho; i++){
        vetor[i] = vetor[i+1];
    }

    //realocacao de memoria para Vetor
    vetor = (int*) realloc(vetor, tamanho-1);
    return (tamanho - 1);
}

void print_vetor(int *vetor, int tamanho){
    printf("\nNovo vetor: \n");
    for(int i = 0; i < tamanho; i++){
        printf("Vetor[%d]: %d\n", i, vetor[i]);
    }

    printf("Tamnho final: %i\n", tamanho);
}