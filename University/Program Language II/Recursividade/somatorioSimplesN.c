#include <stdio.h>

int soma(int n);

int main(){

    int n;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("O resultado é: %d\n", soma(n));


    return 0;
}

int soma(int n){

    if(n == 1){
        return 1;
    }else{
        return n + soma(n-1);
    }


}