#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* criaLista(int vet[], int n);
void imprimir(No* inicio);

int main(){

    No* inicio;
    int vet[5] = {5,4,3,2,1};

    inicio = criaLista(vet, 5);
    
    imprimir(inicio);

    return 0;
}

void imprimir(No* inicio){
    No* p;

    for(p = inicio; p != NULL; p = p->proximo){
        printf("%dº nó\n", p->dado);
    }
}

No* criaLista(int vet[], int n){
    No* lista, *aux;
    lista = NULL;

    if(n == 0) return lista;

    for(int i = 0; i < n; i++){
        aux = (No*) malloc(sizeof(No));
        aux->dado = vet[i];
        aux->proximo = lista;
        lista = aux;
    }

    return lista;
}

