#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

No* inserirInicio(No* inicio, int dado);
No* obtemPares(No* inicio);
void imprimir(No* inicio);

int main(){

    No* inicio, *novaLista;

    novaLista = NULL;
    inicio = NULL;

    inicio = inserirInicio(inicio, 5);
    inicio = inserirInicio(inicio, 4);
    inicio = inserirInicio(inicio, 3);
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 1);

    novaLista = obtemPares(inicio);

    printf("Depois:\n");
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

No* obtemPares(No* inicio){

    No* auxiliar, *novaLista;
    novaLista = NULL;
    auxiliar = inicio;
    int informacao;
    
    while(auxiliar != NULL){
        informacao = auxiliar->dado;
        if(informacao % 2 == 0){
            novaLista = inserirInicio(novaLista, informacao);
        }
        auxiliar = auxiliar->proximo;
    }

    return novaLista;
}
