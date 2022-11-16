#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* inserirInicio(No* inicio, int dado);
int maiores(No* inicio, int n);
void imprimir(No* inicio);

int main(){

    No* inicio, *novaLista;
    int qtd, maior;

    maior = 1;


    inicio = NULL;
    for(int i = 5; i >= 1; i--){
        inicio = inserirInicio(inicio, i);
    }

    qtd = maiores(inicio, maior);

    printf("Existem %d nós que possuem info maiores que %d\n", qtd, maior);

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

int maiores(No* inicio, int n){
    No* novaLista;
    int cont = 0;

    for(novaLista = inicio; novaLista != NULL; novaLista = novaLista->proximo){
        if(novaLista->dado > n){
            cont++;
        }
    }
    return cont;
}