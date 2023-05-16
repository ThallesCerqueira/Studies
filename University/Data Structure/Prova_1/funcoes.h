#ifndef FUNCOES_H
#define FUNCOES_H

typedef struct {

    int appId;
    char *title;
    char *dataRelease;
    char *win;
    char *mac;
    char *linux;
    char *rating;
    int positiveRatio;
    int userReviews;
    float priceFinal;
    float priceOriginal;
    float discount;

} Jogos;


typedef struct ElementoFila{

    Jogos* jogo;
    struct ElementoFila* prox;

} ElementoFila;

typedef struct Fila{

    struct ElementoFila *inicio;
    struct ElementoFila *fim;
    int tam;

} Fila;

Jogos* carregaDados( char *fileName, int *tam ); 
Jogos* criaAcervo( int capacidade ); 

//Funções - FILA
Fila* inicializaFila();
int insereNaFila(Jogos* jogo, Fila* fila);
Jogos* removeDaFila(Fila* fila);
int isFilaVazia(Fila* fila);
void imprimeElementoFila( Fila *fila );

void copiaJogos( Jogos origem, Jogos* destino );

int insereMeio( Jogos* jogo, Fila* fila );
Jogos* removeMeio(Fila* fila);

#endif