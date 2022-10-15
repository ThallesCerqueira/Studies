#include <stdio.h>

int main(){

    int A[] = {1, 3, 5, 7, 9, 11, 13, 15};
    int B[] = {1,1,2,2,3,3,4,4};
    int C[8], aux;

    for(int i = 0; i < 8; i++){
        aux = B[i] % 2;
        if(aux == 0){
            C[i] = A[i] * B[i];
        }else{
            C[i] = A[i] - B[i];
        }
    }

    for(int i = 0; i < 8; i++){
        printf("%iº elemento: %i\n", i+1, C[i]);
    }


    return 0;
}