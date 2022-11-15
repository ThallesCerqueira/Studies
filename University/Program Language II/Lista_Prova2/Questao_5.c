#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* inserirInicio(No* inicio, int dado);
No* removeElemento(No* inicio, int elemento);
void imprimir(No* inicio);

int main(){

    No* inicio;

    inicio = NULL;
    inicio = inserirInicio(inicio, 5);
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 3);
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 1);

    inicio = removeElemento(inicio, 2);

    printf("\n");

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

No* removeElemento(No* inicio, int elemento){
    No *auxiliar, *novaLista;
    novaLista = NULL;

    for(auxiliar = inicio; auxiliar != NULL; auxiliar = auxiliar->proximo){
        if(auxiliar->dado != elemento){
            novaLista = inserirInicio(novaLista, auxiliar->dado);
        }
    }

    return novaLista;
    
}
