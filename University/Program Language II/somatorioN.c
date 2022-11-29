#include <stdio.h>

int somatorioN(int n);

int main(){

    int resultado, entrada;

    printf("Entre com o valor que deseja o somatório: ");
    scanf("%d", &entrada);

    resultado = somatorioN(entrada);

    printf("O resultado é: %d\n", resultado);

    return 0;
}

int somatorioN(int n){

    int resultado = 0;
    if(n == 0){
        return 0;
    }else{
        resultado = n + somatorioN(n - 1);
    }

    return resultado;
}