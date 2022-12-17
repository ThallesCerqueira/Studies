#include <stdio.h>
#include <stdlib.h>

int main(){

    FILE *fp;
    char frase[100];

    //abrindo arquivo
    fp = fopen("leitura.txt", "a");

    //verificando abertura do arquivo
    if(fp == NULL){
        printf("Erro ao abrir arquivo.\n");
        exit(1);
    }

    //Pegando frase do usuario
    printf("Entre com a frase: ");
    gets(frase);

    //escrevendo a frase no arquivo
    //fprintf(fp, frase);
    fputs(frase, fp);

    //Adicionando apenas 1 caracter

    char c = 'c';

    fputc(c, fp);

    return 0;
}