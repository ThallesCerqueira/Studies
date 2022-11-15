#include <stdio.h>
#include <stdlib.h>

struct lista{
    int info;
    struct lista* prox;
};

typedef struct lista LISTA;

LISTA* insere(LISTA* I, int i);
LISTA* remove1(LISTA* inicio, int no);
void imprime(LISTA* I);

int main(){

    LISTA* inicio;

    int a, b, flag;

    flag = 1;
    inicio = NULL;
    
    do{
        printf("Entre com o valor de a: ");
        scanf("%d", &a);

        inicio = insere(inicio, a);

        printf("Deseja continuar? 1 ou 0: ");
        scanf("%d", &flag);

    }while(flag == 1);

    printf("Informe qual nó deve ser tirado: ");
    scanf("%d", &b);

    inicio = remove1(inicio, b);
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

LISTA* remove1(LISTA* inicio, int no){

    LISTA *ListaAux, *ponteiroAuxiliar;

    ListaAux = inicio;
    ponteiroAuxiliar = inicio;

    if(ListaAux == NULL){
        printf("Lista vazia!\n");
    }else{

       if(no == 1){
        ListaAux = ListaAux->prox;
       }else{    
            for(int i = 0; i < no; i++){
                ponteiroAuxiliar = ponteiroAuxiliar->prox; // Caminha até (Nó + 1)
            }

            for(int i = 0; i < (no-1); i++){
                if(i < (no-1)){
                    ListaAux->prox = ponteiroAuxiliar;
                }else{
                    ListaAux = ListaAux->prox;
                }
                
                
            }     
        }

    }

    return ListaAux;


}

void imprime(LISTA* I){
    LISTA* p;

    printf("\nNova lista: \n");
    for(p = I; p != NULL; p = p->prox){
        printf("Valor: %d\n", p->info);
    }
}