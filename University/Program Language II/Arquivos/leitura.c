#include <stdio.h>
#include <stdlib.h>

int main(){
    char frase[100];

    //Declaracao de ponteiro para arquivo
    FILE *fp;
    //vinculando arquivo ao ponteiro
    fp = fopen("C:\\Users\\thall\\Thalles\\University\\Program Language II\\Arquivos\\leitura.txt", "w");
    fprintf(fp, "Escrevendo para depois ler o texto.\nTestando também\na\nquebra de linha.");
    //fechamento do arquivo
    fclose(fp);

    //abrindo arquivo para leitura
    fp = fopen("leitura.txt", "r");

    if(fp == NULL){
        printf("Não foi possível abrir o arquivo!\n");
        exit(1);
    }

    //lendo do arquivo, pega apenas 1 linha. 
    fgets(frase, 100, fp);

    //vendo resultado
    printf("%s\n", frase);

    //lendo e printando do arquivo, pegando todo conteudo

    while(fgets(frase,100,fp) != NULL){
        printf("%s", frase);
    }

    fclose(fp);
}