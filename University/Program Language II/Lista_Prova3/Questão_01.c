#include <stdio.h>

int calculadora(int multiplicando, int multiplicador);

int main(){

    int multiplicando, multiplicador, resultado;

    printf("Entre com o multiplicando: ");
    scanf("%d", &multiplicando);
    printf("Entre com o multiplicador: ");
    scanf("%d", &multiplicador);

    resultado = calculadora(multiplicando, multiplicador);

    printf("O produto %dx%d é: %d\n", multiplicando, multiplicador, resultado); 

    return 0;
}

int calculadora(int multiplicando, int multiplicador){


    if(multiplicador == 1){
        return multiplicando;
    }

    return multiplicando + calculadora(multiplicando, multiplicador - 1);

}