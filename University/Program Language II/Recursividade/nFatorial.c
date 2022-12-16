#include <stdio.h>

int fi(int n);

int main(){

    int n, resultado;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    resultado = fi(n);

    printf("O %dº termo é: %d\n", n, resultado);

    return 0;
}

int fi(int n){
    
    if(n == 1){
        return 0;
    }else{
        if(n == 2){
            return 1;
        }else{
            return fi(n -1 ) + fi(n - 2);
        }
    }
}