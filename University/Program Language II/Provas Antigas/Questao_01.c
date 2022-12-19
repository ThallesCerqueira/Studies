#include <stdio.h>

int Maior_elem_vetor(int *vet, int tam);

int main(){

    int v[4] = {5,2,4,3};

    printf("O maior é: %d\n", Maior_elem_vetor(v, 4));

}

int Maior_elem_vetor(int *vet, int tam){
    int maior;

    if(tam == 1){
        return vet[tam-1];
    }else{
        if(vet[tam - 1] > Maior_elem_vetor(vet, tam -1)){
            return vet[tam-1];
        }else{
            return Maior_elem_vetor(vet, tam -1);
        }
    }


}