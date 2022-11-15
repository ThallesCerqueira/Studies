#include <stdio.h>
#include <stdlib.h>

struct no{
    int dado;
    struct no *proximo;
};

typedef struct no No;

//Procedimento para inserir no início
No* inserirInicio(No* inicio, int dado);
void imprimir(No* inicio);

int main(){

    No* inicio;

    inicio = NULL;
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 1);

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