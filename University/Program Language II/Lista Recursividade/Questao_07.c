#include <stdio.h>

int soma(int n, int i);

int main(){
    int n,  i;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("Entre com o valor de i: ");
    scanf("%d", &i);

    printf("O resultado é: %d\n", soma(n,i));

    return 0;
}

int soma(int n, int i){

    if(i == 0){
        return n;
    }else{
        return n + soma(1, i-1);
    }
}