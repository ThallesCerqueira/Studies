/*
    Como já foi dito em sala de aula, este algoritmo possui complexidade log2 n.
*/

#include <stdio.h>

char* int2bin(int n);

int main() {

    int n;
    char *resultado;

    do{

        printf("\nEntre com o valor de n: ");
        scanf("%d", &n);

        if(n < 1) printf("Valor inválido, digite um valor acima de 0.\n");

    }while(n < 1);

    resultado = int2bin(n);

    return 0;
}

char* int2bin(int n){

    if(n == 0){
        return 0;
    }else{
        int2bin(n / 2);
        printf("%d", n%2);
    }

}

void limparTela() {
    printf("\e[1;1H\e[2J");
}