#include <stdio.h>

void bin(int n);

int main(){

    int n;

    printf("Entre com um valor decimal: ");
    scanf("%d", &n);

    bin(n);

    return 0;
}

void bin(int n){
    int aux;
    if(n == 0){
        printf("0");
    }else{
        bin(n / 2);  
        printf("%d", n%2);
    }
}