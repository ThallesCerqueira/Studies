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
    inicio = inserirInicio(inicio, 4);
    inicio = inserirInicio(inicio, 3);
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 1);

    inicio = removeElemento(inicio, 5);

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
    No *auxiliar, *ponteiroParaSeguinte;
    int contador = 0;
    
    auxiliar = inicio;

    if(auxiliar->dado == elemento){
        inicio = inicio->proximo;
    }

    while(auxiliar->dado != elemento){
        contador++;
        printf("Valor do elemento: %d\n", auxiliar->dado);

        auxiliar = auxiliar->proximo;

        if(auxiliar->dado == elemento){
            printf("Entrei e parei!\n");
            ponteiroParaSeguinte = auxiliar->proximo;
        }
    }

    auxiliar = inicio;
    for(int i = 1; i <= contador; i++){
        if(i == contador){
            auxiliar->proximo = ponteiroParaSeguinte;
        }else{
            auxiliar = auxiliar->proximo;
        }
    }

    //printf("Contador: %d", contador);

    return inicio;
}