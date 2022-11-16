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
No* removeNo(No* inicio, int posNo);

int main(){

    No* inicio;

    inicio = NULL;
    inicio = inserirInicio(inicio, 5);
    inicio = inserirInicio(inicio, 4);
    inicio = inserirInicio(inicio, 3);
    inicio = inserirInicio(inicio, 2);
    inicio = inserirInicio(inicio, 1);

    inicio = removeNo(inicio, 4);

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

No* removeNo(No* inicio, int posNo){
    No *auxiliar, *ponteiroParaSeguinte;
    
    if(posNo == 1){
        inicio = inicio->proximo;
    }else{
        
        auxiliar = inicio;
        for(int posicao = 1; posicao <= posNo; posicao++){
            auxiliar = auxiliar->proximo;
            if(posicao == (posNo - 1)){
                ponteiroParaSeguinte = auxiliar->proximo;
            }
        }

        auxiliar = inicio;
        for(int posicao = 1; posicao < posNo; posicao++){
               
            if(posicao == (posNo - 1)){
                auxiliar->proximo = ponteiroParaSeguinte;
            }else{
                auxiliar = auxiliar->proximo;
            }
        }
    }
    return inicio;
}