#include <stdio.h>

int fibo(int n);

int main(){

    int n, resposta, n1, n2;
    n1 = n2 = 1;

    printf("Entre com o termo desejado: ");
    scanf("%d", &n);

    //Output para implementação recursiva
    resposta = fibo(n);
    printf("RECURSIVO - Valor: %d\n", resposta);

    //Output para implementação não recursiva
    resposta = fiboNaoRecursivo(n);
    printf("NÃO RECURSIVO - Valor: %d\n", resposta);

    return 0;
}

int fibo(int n) {

    if(n  == 1 || n == 2) {

        return 1;

    }else {

        return fibo( n - 1) + fibo(n - 2);
        
    }

}

int fiboNaoRecursivo( int n ) {

    int resposta, n1, n2;
    n1 = n2 = 1;

    if(n == 1 || n == 2) {

        return 1;
    
    }else {

        for(int i = 3; i <= n; i++) {

            resposta = n1 + n2;
            n1 = n2;
            n2 = resposta;
        }

    }

    return resposta;

}