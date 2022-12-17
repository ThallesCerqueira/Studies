#include <stdio.h>

void copia(FILE *f1, FILE *f2);

int main(){

    FILE *f1, *f2;

    //abrindo arquivo para escrita
    f1 = fopen("original.txt", "w");
    fprintf(f1, "Gerando texto para ser copiado.");
    fclose(f1);

    //abrindo arquivo para leitura
    f1 = fopen("original.txt", "r");
    if(f1 == NULL){
        printf("Não foi possível abrir o arquivo.\n");
        return 0;
    }

    //abrindo arquivo para escrita
    f2 = fopen("copia.txt", "w");
    
    //chamando funcao
    copia(f1,f2);

    //fechando arquivos
    fclose(f1);
    fclose(f2);

    return 0;
}

void copia(FILE *f1, FILE *f2){

    char leitor[1000];

    while(fgets(leitor, 1000, f1) != NULL){
        fputs(leitor, f2);
    }
}