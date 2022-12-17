#include <stdio.h>

int main(){

    //Declaracao de ponteiro para arquivo
    FILE *fp;
    //vinculando arquivo ao ponteiro
    fp = fopen("C:\\Users\\thall\\Thalles\\University\\Program Language II\\Arquivos\\introducao.txt", "w");
    fprintf(fp, "Testando a função fprintf.");
    //fechamento do arquivo
    fclose(fp);
}