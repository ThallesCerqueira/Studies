#include <stdio.h>
#include <stdlib.h>

char *strcopy(char *str);

int main(){

    //Declaração das variáveis
    char *ponteiroDaCopia;
    char string[] = "Copiando";

    //chamada da funcao 
    ponteiroDaCopia = strcopy(string);

    for(int i = 0; ponteiroDaCopia[i] != '\0'; i++){
        printf("%c", ponteiroDaCopia[i]);
    }

    return 0;
}

char *strcopy(char *str){

    char *copia;
    copia = &str[0];

    //copia dos valores
    for(int i = 0; str[i] != '\0'; i++){
        copia[i] = str[i];
    }

    return copia;
}