#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "funcoes.h"
#define TRUE 1
#define FALSE 0

Jogos *criaAcervo(int capacidade)
{

    Jogos *acervo;

    acervo = (Jogos *)malloc((capacidade + 1) * sizeof(Jogos));

    return acervo;
}

Jogos *carregaDados(char *fileName, int *tam)
{

    int i = 0;
    char sep[1], str[2000], *ok;
    sep[0] = ',';
    Jogos *acervo;
    FILE *fp;
    fp = fopen(fileName, "r");
    acervo = criaAcervo(*tam);

    if (fp == NULL)
    {
        printf("Arquivo não pode ser aberto\n");
        exit(1);
    }

    ok = fgets(str, 2000, fp); // Pega cabeçalho

    if (!ok)
    {
        printf("Erro ao o cabeçalho do CSV!!!");
        exit(1);
    }

    while (!feof(fp) && i < *tam)
    {
        ok = fgets(str, 2000, fp); // pega a linha do CSV

        if (ok)
        {
            char *campo;

            // APP ID
            campo = strtok(str, sep); // pega a string até a primeira ','
            acervo[i].appId = atoi(campo);

            // TITLE
            campo = strtok(NULL, sep);
            int pos = 0;
            while (campo[pos] != 15 && pos < strlen(campo))
                pos++;
            campo[pos] = '\0';
            acervo[i].title = (char *)malloc(strlen(campo));
            strcpy(acervo[i].title, campo);

            // Data release
            campo = strtok(NULL, sep);
            pos = 0;
            while (campo[pos] != 15 && pos < strlen(campo))
                pos++;
            campo[pos] = '\0';
            acervo[i].dataRelease = (char *)malloc(strlen(campo));
            strcpy(acervo[i].dataRelease, campo);

            // WINDOWS
            campo = strtok(NULL, sep);
            acervo[i].win = (char *)malloc(strlen(campo));
            strcpy(acervo[i].win, campo);

            // MAC
            campo = strtok(NULL, sep);
            acervo[i].mac = (char *)malloc(strlen(campo));
            strcpy(acervo[i].mac, campo);

            // LINUX
            campo = strtok(NULL, sep);
            acervo[i].linux = (char *)malloc(strlen(campo));
            strcpy(acervo[i].linux, campo);

            // RATING
            campo = strtok(NULL, sep);
            pos = 0;
            while (campo[pos] != 15 && pos < strlen(campo))
                pos++;
            campo[pos] = '\0';
            acervo[i].rating = (char *)malloc(strlen(campo));
            strcpy(acervo[i].rating, campo);

            // POSITIVE RATIO
            campo = strtok(NULL, sep);
            acervo[i].positiveRatio = atoi(campo);

            // USER REVIEWS
            campo = strtok(NULL, sep);
            acervo[i].userReviews = atoi(campo);

            // PRICE FINAL
            campo = strtok(NULL, sep);
            acervo[i].priceFinal = atof(campo);

            // PRICE ORIGINAL
            campo = strtok(NULL, sep);
            acervo[i].priceOriginal = atof(campo);

            // DISCOUNT
            campo = strtok(NULL, sep);
            acervo[i].discount = atof(campo);

            i++;
        }
    }

    return acervo;
}

Fila *inicializaFila()
{

    Fila *fila = (Fila *)malloc(sizeof(Fila));

    fila->inicio = NULL;
    fila->fim = NULL;
    fila->tam = 0;

    return fila;
}

int insereNaFila(Jogos *jogo, Fila *fila)
{
    ElementoFila* elementoFila = (ElementoFila*) malloc(sizeof(ElementoFila));

    elementoFila->jogo = jogo;
    elementoFila->prox = NULL;
    
    if (fila->tam == 0) {
        fila->inicio = elementoFila;
    } else {
        fila->fim->prox = elementoFila;
    }

    fila->fim = elementoFila;
    fila->tam++;

    return 1;
}

void imprimeElementoFila( Fila *fila ) {

    ElementoFila* aux = fila->inicio;

    while( aux != NULL ) {
        printf("%s\n", aux->jogo->title);
        aux = aux->prox;
    }

}

int insereMeio(Jogos* jogo, Fila* fila) {
    
    if (fila->tam < 3) return 0;

    ElementoFila* elementoFila = ( ElementoFila* ) malloc( sizeof(ElementoFila) );
    ElementoFila* anterior;
    ElementoFila* aux;
    int meio;

    elementoFila->jogo = jogo;
    elementoFila->prox = NULL;
    anterior = fila->inicio;
    aux = anterior->prox;
    
    int i = 1;
    while ( aux != NULL ) {
        meio = fila->tam / 2;
        if (i == meio) {
            anterior->prox = elementoFila;
            elementoFila->prox = aux;
            break;
        }

        anterior = aux;
        aux = aux->prox;

        i++;
    }

    fila->tam++;
    
    return 0;
}

Jogos* removeMeio( Fila* fila ) {
   
    if (fila->tam < 3) return NULL;
    
    ElementoFila* anterior;
    ElementoFila* aux;
    Jogos* removido; 
    int i, meio;

    anterior = fila->inicio;
    aux = anterior->prox;
    
    i = 1;
    while ( aux != NULL ) {

        meio =  fila->tam / 2;

        if ( i == meio ) {

            anterior->prox = aux->prox;
            removido = aux->jogo;
            free( aux );
            fila->tam--;
            return removido;

        }

        anterior = aux;
        aux = aux->prox;
        i++;

    }

}