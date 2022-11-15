#include <stdio.h>
#include <stdlib.h>

struct lista{
    int info;
    struct lista* prox;
};

typedef struct lista LISTA;

LISTA* insere(LISTA* I, int i);
void imprime(LISTA* I);

int main(){

    LISTA* inicio;

    int a, flag;

    flag = 1;

    inicio = NULL;
    
    do{
        printf("Entre com o valor de a: ");
        scanf("%d", &a);

        inicio = insere(inicio, a);

        printf("Deseja continuar? 1 ou 0: ");
        scanf("%d", &flag);
    }while(flag == 1);
    

    imprime(inicio);


    return 0;
}

LISTA* insere(LISTA* I, int i){
    LISTA* novo = (LISTA*) malloc(sizeof(LISTA));

    if(novo == NULL) printf("Erro");
    novo->info = i;
    novo->prox = I;

    return novo;
}

void imprime(LISTA* I){
    LISTA* p;

    for(p = I; p != NULL; p = p->prox){
        printf("Valor: %d\n", p->info);
    }
}
