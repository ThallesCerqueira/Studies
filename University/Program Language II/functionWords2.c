#include <stdio.h>

int functionWords2(char palavra[]);

int main(){

    int resultado;
    char palavra[] = "abcde";

    resultado = functionWords2(palavra);

    printf("A quantidade de consoantes é: %d\n", resultado);

    return 0;
}

int functionWords2(char palavra[]){

    int contador = 0;
    int contador2 = 0;

    for(int i = 0; palavra[i] != '\0'; i++){

        if(palavra[i] == 'a'|| palavra[i] == 'e' || palavra[i] == 'i' || palavra[i] == 'o' || palavra[i] == 'u'){
            contador++;
        }else if(palavra[i] >= 97 && palavra[i] <= 122){
            contador2++;
        }
    }

    return contador2;
}