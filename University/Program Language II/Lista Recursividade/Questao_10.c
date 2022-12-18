#include <stdio.h>

int nacci(int n);

int main(){
    int n;

    printf("Entre com o N-ésimo termo: ");
    scanf("%d", &n);

    printf("O resultado é: %d\n", nacci(n));

    return 0;
}

int nacci(int n){
    if(n == 1 || n == 2 || n == 3 || n == 4){
        if(n == 4){
            return 1;
        }
        return 0;
    }else{
        return nacci(n-1) + nacci(n-2) + nacci(n-3) + nacci(n-4);
    }
}