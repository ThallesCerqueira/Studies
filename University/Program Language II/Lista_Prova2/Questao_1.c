#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct lista{
    int info;
    struct lista* prox;
};

typedef struct lista LISTA;

LISTA* insere(LISTA* I, int i);
int maior(LISTA* I);
void imprime(LISTA* I);

int main(){

    LISTA* inicio;

    int a, flag, Max;

    flag = 1;
    inicio = NULL;
    
    do{
        printf("Entre com o valor de a: ");
        scanf("%d", &a);

        inicio = insere(inicio, a);

        printf("Deseja continuar? 1 ou 0: ");
        scanf("%d", &flag);

    }while(flag == 1);
    

    Max = maior(inicio);

    printf("\nO maior da lista é: %d\n", Max);

    imprime(inicio);


    return 0;
}

LISTA* insere(LISTA* I, int i){
    LISTA* novo = (LISTA*) malloc(sizeof(LISTA));

    if(novo == NULL) printf("Erro!\n");
    novo->info = i;
    novo->prox = I;

    return novo;
}

void imprime(LISTA* I){
    LISTA* p;

    printf("\nInicio da lista: \n");
    for(p = I; p != NULL; p = p->prox){
        printf("Valor: %d\n", p->info);
    }
}

int maior(LISTA* I){
    LISTA* Aux;
    int maior = INT_MIN;

    for(Aux = I; Aux != NULL; Aux = Aux->prox){
        if(Aux->info > maior){
            maior = Aux->info;
        }
    }

    return maior;

}
