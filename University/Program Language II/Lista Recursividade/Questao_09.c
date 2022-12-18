#include <stdio.h>

int super(int n);

int main(){
    int n;

    printf("Entre com o N-ésimo termo: ");
    scanf("%d", &n);

    printf("O resultado é: %d\n", super(n));

    return 0;
}

int super(int n){

    if(n == 1){
        return 1;
    }else{
        return ((n * super(n-1)) * (n * super(n-1)));
    }
}