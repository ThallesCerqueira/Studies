#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* inserirInicio(No* inicio, int dado);
No* removeRepetidos(No* inicio);
void imprimir(No* inicio);

int main(){

    No* inicio;

    inicio = NULL;
    for(int i = 0; i < 5; i++){
        inicio = inserirInicio(inicio, i);
    }

    inicio = removeRepetidos(inicio);

    imprimir(inicio);

    return 0;
}

No* inserirInicio(No* inicio, int dado){
    No *novo;
    novo = (No*)malloc(sizeof(No));

    if(novo){
        novo->dado = dado;
        novo->proximo = inicio;
        return novo;
    }else{
        printf("Erro ao alocar memória;");
    }
}

void imprimir(No* inicio){
    No* p;

    for(p = inicio; p != NULL; p = p->proximo){
        printf("%dº nó\n", p->dado);
    }
}

No* removeRepetidos(No* inicio){
    No *auxiliar, *lista, *vet;
    int tamanho = 0;

    for(auxiliar = inicio; auxiliar != NULL; auxiliar = auxiliar->proximo){
        tamanho++;
    }

    vet = (int)malloc(sizeof(int) * tamanho);

    auxiliar = inicio;
    int a = auxiliar->dado;
    //vet[0] = a;
    

}