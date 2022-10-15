#include <stdio.h>
#include <stdlib.h>

char *strcopy(char *str, char *copia);

int main(){

    //Declaração das variaveis
    char *ponteiroDaCopia;
    char copia[2];
    char *string = "la";

    //Chamada da funcao strcopy
    ponteiroDaCopia = strcopy(string, copia);

    //Output da copia
    printf("A cópia é: %c\n", ponteiroDaCopia[0]);

    return 0;
}

char *strcopy(char *str, char *copia){

    //copia dos valores
    while(*str != '\0'){
        *copia = *str;
        copia++;
        str++;
    }
    return copia;
}