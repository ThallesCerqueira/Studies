#include <stdio.h>

int numberPrimo(int n);

int main(){

    int value, resultado;

    printf("Entre com um numero para sabermos se ele é primo: ");
    scanf("%d", &value);

    resultado = numberPrimo(value);

    if(resultado == 1){
        printf("O número %d é primo.\n", value);
    }else{
        printf("O número %d não é primo.\n", value);
    }

    return 0;
}

int numberPrimo(int value){

    int contador = 0, resultado;

    for(int i = 1; i <= value; i++){
        if((value % i) == 0){
            contador++;
        }
    }

    if(contador > 2){
        return 0;
    }else{
        return 1;
    }
}