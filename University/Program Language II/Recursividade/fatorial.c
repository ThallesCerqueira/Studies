#include <stdio.h>

int fat(int n);

int main(){

    int n;

    printf("Informe o valor de n: ");
    scanf("%d", &n);

    n = fat(n);

    printf("O resultado é: %d\n", n);

    return 0;
}

int fat(int n){

    if(n == 1){
        return 1;
    }else{
        return n * fat(n-1);
    }

}