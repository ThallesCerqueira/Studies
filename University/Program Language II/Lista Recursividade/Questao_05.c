#include <stdio.h>

int mod(int x, int y);

int main(){
    int x, y;

    printf("Entre com o valor de x: ");
    scanf("%d", &x);

    printf("Entre com o valor de Y: ");
    scanf("%d", &y);

    printf("O resultado é: %d", mod(10,4));


    return 0;
}

int mod(int x, int y){
    if(x>= y && x%y == 0){
        return y;
    }else if(x < y){
        return mod(y,x);
    }else{
        return mod(y, x%y);
    }
}