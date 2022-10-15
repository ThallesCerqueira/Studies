#include <stdio.h>

void func_hexa(int *vetor);

int main(){

    //declaracao do vetor
    int vetor[5] = {1,2,3,4,5};

    //chamada da funcao
    func_hexa(vetor);

    return 0;
}

void func_hexa(int *vetor){
    for(int i = 0; i < 5; i++) printf("Endereço de %i em hexa: %x\n", vetor[i], &vetor[i]);
}