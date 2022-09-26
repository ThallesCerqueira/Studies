#include <stdio.h>

int abs(int value);

int main(){

    int value, absoluto;

    printf("Entre com um número para saber o valor Absoluto: ");
    scanf("%d", &value);

    absoluto = abs(value);

    printf("O valor absoluto de [%d] é: %d\n", value, absoluto);


    return 0;
}

int abs(int value){

    if (value < 0){
        value = value * (-1);
    }

    return value;

}