#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "funcoes.h"

int main() {

    Jogos *acervo, *removido;
    Fila *fila;

    int tamanhoAcervo = 10;

    //Carregando dados para o acervo
    acervo = carregaDados("../../Data/dataSetEquipe2.csv", &tamanhoAcervo);

    fila = inicializaFila();

    insereNaFila( &acervo[0], fila );
    insereNaFila( &acervo[1], fila );
    insereNaFila( &acervo[2], fila );
    insereNaFila( &acervo[3], fila );

    imprimeElementoFila( fila );

    insereMeio( &acervo[4], fila); 

    printf("\n");

    imprimeElementoFila( fila );

    removido = removeMeio(fila);
    printf("\n");
    printf("Elemento removido: %s", removido->title);

    printf("\n");
    printf("\n");
    imprimeElementoFila( fila );
    printf("\n");

    return 0;
}