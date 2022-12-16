#include <stdio.h>

int potencia(int x, int n);

int main(){

    int n, x, resultado;

    printf("Entre com o valor de X e de N: ");
    scanf("%d%d", &x, &n);

    resultado = potencia(x,n);

    printf("O resultado é: %d\n", resultado);


    return 0;
}

int potencia(int x, int n){

    if(n == 1){
        return x;
    }else{
        return x * potencia(x, n -1);
    }

}