#include <stdio.h>

int main(){

    int v[5] = {1,2,3,4,5}, i;
    int *PtrV;

    PtrV = v;

    printf("Valor de V: %d\n", *PtrV);

    PtrV+=4;

    printf("Depois da modificação: \n");
    printf("Valor de V: %d\n", *PtrV);

    for(int i = 0; i < 4; i++){
        PtrV--;
        printf("Valor de V: %d\n", *PtrV);
    
    }
    
    return 0;
}