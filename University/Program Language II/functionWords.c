#include <stdio.h>

int functionWords(char palavra[]);

int main(){

    int resultado;
    char palavra[] = "agora é um teste";

    resultado = functionWords(palavra);

    printf("A quantidade de vogais é: %d\n", resultado);

    return 0;
}

int functionWords(char palavra[]){

    int contador = 0;

    for(int i = 0; palavra[i] != '\0'; i++){

        if(palavra[i] == 'a'|| palavra[i] == 'e' || palavra[i] == 'i' || palavra[i] == 'o' || palavra[i] == 'u'){
            contador++;
        }
    }

    return contador;
}