#include <stdio.h>

int pad(int n);

int main(){
    int n;

    printf("Digite o N-ésimo termo: ");
    scanf("%d", &n);

    printf("O resultado é: %d\n", pad(n));

    return 0;
}

int pad(int n){

    if(n == 0 || n == 1 || n == 2){
        return 1;
    }else{
        return pad(n - 2) + pad(n - 3);
    }

}