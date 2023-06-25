#include <stdio.h>
#include <stdlib.h>
#include "funcoes.h"
#include <time.h>
#define N 10

int main(void){
   PInfo lista;
   srand(time(NULL));
  
   lista = (PInfo) malloc(N * sizeof(TInfo));

  printf("LISTA ORIGINAL: \n");
   for(int i = 0; i < N; i++){
       lista[i].key = rand() % 40;
       lista[i].val = 5.0*rand()/RAND_MAX + rand()%10;
       printf("(%d, %.2f)  ", lista[i].key, lista[i].val);
   }

  //Inserindo na árvore
   PNoArvBin arv = NULL;
   for(int i = 0; i < N; i++)
       arv = insereNoArv_D(arv, lista[i]);

  // Ordenando a lista
   bubbleSort(lista, N);
  printf("\n\nLISTA ORDENADA:\n");
   for(int i = 0; i < N; i++)
       printf("(%d, %.2f)  ", lista[i].key, lista[i].val);
   printf("\n");

  printf("\nÁRVORE COMPLETA:\n");
  printArv(arv);
  printf("\n");

    // Removendo primeiros 5 elementos
   for(int i = 0; i < 5; i++)
       arv = removeDaArv(arv, lista[i].key);

  printf("\nÁRVORE SEM OS 5 PRIMEIROS ELEMENTOS:\n");
  printArv(arv);

  limpa(arv);
  printf("\n\nTentando limpar a árvore depois do Free:\n");
  printArv(arv);
  printf("\n");
  
   return 0;
}
