#include <stdio.h>
#include <stdlib.h>

struct lista{
    int info;
    struct lista* prox;
};

typedef struct lista LISTA;

LISTA* insere(LISTA* I, int i);
int quant(LISTA* I);


int main(){

    LISTA* inicio;

    int a, flag, quantidade;

    flag = 1;
    inicio = NULL;
    
    do{
        printf("Entre com o valor de a: ");
        scanf("%d", &a);

        //a = rand() % 10;

        inicio = insere(inicio, a);

        printf("Deseja continuar? 1 ou 0: ");
        scanf("%d", &flag);

    }while(flag == 1);

    quantidade = quant(inicio);

    printf("A quantidade de elementos é: %d\n", quantidade);
    

    return 0;
}

LISTA* insere(LISTA* I, int i){
    LISTA* novo = (LISTA*) malloc(sizeof(LISTA));

    if(novo == NULL) printf("Erro!\n");
    novo->info = i;
    novo->prox = I;

    return novo;
}

int quant(LISTA* I){
    LISTA* p;
    int cont = 0;

    for(p = I; p != NULL; p = p->prox){
        cont++;
    }


    return cont;
}

