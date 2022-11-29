#include <stdio.h>

int main(){

    int resultado, entrada;

    printf("Qual fatorial deseja calcular? ");
    scanf("%d", &entrada);

    resultado = fatorial(entrada);

    printf("O resultado é: %d\n", resultado);



    return 0;
}

int fatorial(int n){

    int resultado;

    if(n == 1){
        return 1;
    }else{
        resultado = n * fatorial(n-1);
    }

    return resultado;
}