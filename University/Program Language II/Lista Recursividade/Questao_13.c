#include <stdio.h>

int fun(int n);

int main(){

    int n;

    printf("Entre com o valor de n: ");
    scanf("%d", &n);

    printf("O resultado é: %d\n", fun(n));

    return 0;
}

int fun(int n){

    if(n == 0){
        return n;
    }else{
        return n%10 + fun(n/10);
    }


}