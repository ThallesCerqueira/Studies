#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* inserirInicio(No* inicio, int dado);
No* exclui_qtde(No* inicio, int n);
void imprimir(No* inicio);

int main(){

    No* inicio, *novaLista;

    inicio = NULL;
    for(int i = 5; i >= 1; i--){
        inicio = inserirInicio(inicio, i);
    }

    novaLista = exclui_qtde(inicio, 0);

    printf("\n");

    imprimir(novaLista);

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

No* exclui_qtde(No* inicio, int n){
    No* novaLista, *auxiliar;
    novaLista = NULL;
    auxiliar = inicio;

    for(int i = 1; auxiliar != NULL; i++){
        if(i > n){
            novaLista = inserirInicio(novaLista, auxiliar->dado);
            auxiliar = auxiliar->proximo;
        }else{
            auxiliar = auxiliar->proximo;
        }
    }
    return novaLista;
}

