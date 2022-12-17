#include <stdio.h>

int main(){

    //Declaracao de ponteiro para arquivo
    FILE *fp;

    //vinculando arquivo ao ponteiro
    fp = fopen("introducao.txt", "w");


    fprintf(fp, "Testando a função fprintf.");

    //fechamento do arquivo
    fclose(fp);


}