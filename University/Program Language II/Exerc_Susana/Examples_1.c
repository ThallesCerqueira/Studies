#include <stdio.h>
#include <stdlib.h>

int main(){

    int A, B, C;

    A = 1;
    B = 2;
    C = 3;

    int *PtrA, *PtrB, *PtrC;

    PtrA = &A;
    PtrB = &B;
    PtrC = &C;

    printf("Endereço de A: %d\n", *PtrA);
    printf("Endereço de B: %d\n", *PtrB);
    printf("Endereço de C: %d\n", *PtrC);

    printf("\n");

    *PtrA = 10;
    *PtrB = 20;
    *PtrC = 30;

    printf("Depois da modificação!\n\n");
    printf("Endereço de A: %d\n", *PtrA);
    printf("Endereço de B: %d\n", *PtrB);
    printf("Endereço de C: %d\n", *PtrC);

    printf("\n\n\n");

    printf("Endereço pelo ê comercial: %p\n", &A);
    printf("Endereço através do ponteiro: %p\n", PtrA);

    printf("\n\n");

    printf("O valor de ""A"" pela variavel: %d\n", A);
    printf("O valor de ""A"" pelo ponteiro: %d\n", *PtrA);



    return 0;
}