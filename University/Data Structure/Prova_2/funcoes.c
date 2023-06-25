#include <stdio.h>
#include <stdlib.h>
#include "funcoes.h"

PNoArvBin newNoArvBin()
{
   PNoArvBin arv = (PNoArvBin) malloc(sizeof( noArvBin ));
   arv->dir = NULL;
   arv->esq = NULL;
   arv->altura = 0;
  
   return arv;
}

short int alturaDoNo(PNoArvBin arv) {
  
   if(arv == NULL)
       return -1;
   else
       return arv->altura;

}

PNoArvBin insereNoArv_B(PNoArvBin arv, TInfo info){
   if(arv == NULL){
       arv = newNoArvBin();
       arv->info = info;
     
   }else if(info.key < arv->info.key) {
     
     arv->esq = insereNoArv_B(arv->esq, info);
     
   }else if (info.key > arv->info.key) {
     
     arv->dir = insereNoArv_B(arv->dir, info);
     
   }  
   short a = alturaDoNo(arv->esq);
   short b = alturaDoNo(arv->dir);
   arv->altura = ((a > b) ? a : b) + 1;
   return arv;
}


PNoArvBin insereNoArv_D(PNoArvBin arv, TInfo info){
   if(arv == NULL){
       arv = newNoArvBin();
       arv->info = info;
   }else if(info.key < arv->info.key)
       arv->esq = insereNoArv_D(arv->esq, info);
   else
       arv->dir = insereNoArv_D(arv->dir, info);
   short a = alturaDoNo(arv->esq);
   short b = alturaDoNo(arv->dir);
   arv->altura = ((a > b) ? a : b) + 1;
   return arv;
}

int percorreArv(PNoArvBin arv, PInfo lista, int i)
{
   if(arv != NULL)
   {
       i = percorreArv(arv->esq, lista, i);
       lista[i++] = arv->info;
       i = percorreArv(arv->dir, lista, i);
   }
   return i;
}

PNoArvBin removeDaArv(PNoArvBin arv, int key)
{
   if(arv->info.key == key){
       if(arv->esq == NULL && arv->dir == NULL){
           free(arv);
           return NULL;
       }else if(arv->esq == NULL){
           PNoArvBin aux = arv->dir;
           free(arv);
           arv = aux;
       }else if(arv->dir == NULL){
           PNoArvBin aux = arv->esq;
           free(arv);
           arv = aux;
       }else{
           PNoArvBin aux = arv->esq;
           while(aux->dir != NULL)
               aux = aux->dir;
           arv->info = aux->info;
           arv->esq = removeDaArv(arv->esq, aux->info.key);
       }
   }else if(key < arv->info.key)
       arv->esq = removeDaArv(arv->esq, key);
   else
       arv->dir = removeDaArv(arv->dir, key);
   short a = alturaDoNo(arv->esq);
   short b = alturaDoNo(arv->dir);
   arv->altura = ((a > b) ? a : b) + 1;
   return arv;
}

void bubbleSort(PInfo lista, int n){
   int trocou = 0;
   for(int i = 0; i < n-1; i++)
   {
       trocou = 0;
       for(int j = 0; j < n - 1 - i; j++){  
           if(lista[j].key > lista[j+1].key){  
               trocou = 1;
               TInfo aux = lista[j];
               lista[j] = lista[j+1];
               lista[j+1] = aux;
           }
       }
       if(!trocou) break;
    }
}

PInfo ordenaLista(PInfo lista, int tam)
{
   PNoArvBin arv = NULL;
   for(int i = 0; i < tam; i++)
       arv = insereNoArv_D(arv, lista[i]);
  
   percorreArv(arv, lista, 0);
}

void printArv( PNoArvBin arv ) {

  if(arv == NULL) return;
  printArv( arv->esq );
  printf("(%d, %.2f)  ", arv->info.key, arv->info.val);
  printArv( arv->dir );
  
}

void limpa( PNoArvBin arv ) {

  if( arv == NULL ) return;

  limpa(arv->esq);
  limpa(arv->dir);

  free(arv);
  
}