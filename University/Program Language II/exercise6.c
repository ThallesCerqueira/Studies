#include <stdio.h>
#include <stdlib.h>

int main(){

    //declaracao das variaveis
    int tamanho_vetor, *ponteiroVetorPrincipal, *ponteiroVetorImpar, *ponteiroVetorPar;
    int impar, par, auxImpar, auxPar;
    impar = par = auxImpar = auxPar = 0;

    printf("Informe o tamanho do vetor: ");
    scanf("%i", &tamanho_vetor);

    //alocacao da memoria para ponteiroVetorPrincipal
    ponteiroVetorPrincipal = (int*)malloc(tamanho_vetor * sizeof(int));

    //leitura do vetor
    for(int i = 0; i < tamanho_vetor; i++){
        printf("Entre com o %iº valor: ", i+1);
        scanf("%i", &ponteiroVetorPrincipal[i]);
    }

    //contagem de pares e ímpares
    for(int i = 0; i < tamanho_vetor; i++){

        if(ponteiroVetorPrincipal[i] % 2){ //contador para impar, pq resulta 0 para par, e 1 para impar
            impar++;
        }else{
            par++;
        }

    }

    //alocacao da memoria para ponteiroVetorImpar
    ponteiroVetorImpar = (int*)malloc(impar * sizeof(int));

    //alocacao da memoria para ponteiroVetorPar
    ponteiroVetorPar = (int*)malloc(par * sizeof(int));

    for(int i = 0; i < tamanho_vetor; i++){
        if(ponteiroVetorPrincipal[i] % 2){ //entrada no bloco valores impares
            ponteiroVetorImpar[auxImpar] = ponteiroVetorPrincipal[i];
            auxImpar++;
        }else{
            ponteiroVetorPar[auxPar] = ponteiroVetorPrincipal[i];
            auxPar++;
        }
    }

    printf("\n");
    //printf do ponteiroVetorPrincipal
    for(int i = 0; i < tamanho_vetor; i++){
        printf("Vetor principal: %d\n", ponteiroVetorPrincipal[i]);
    }

    printf("\n");
    //printf do ponteiroVetorPar
    for(int i = 0; i < par; i++){
        printf("Vetor Par: %d\n", ponteiroVetorPar[i]);
    }

    printf("\n");
    //print do ponteiroVetorImpar
    for(int i = 0; i < impar; i++){
        printf("Vetor Impar: %d\n", ponteiroVetorImpar[i]);
    }

    return 0;
}