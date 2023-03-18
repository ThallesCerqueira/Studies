#include <stdio.h>
#include <limits.h>
#include <stdlib.h>
#include <time.h>

int maximo(int array[], int n);
int minimo(int array[], int n);
void gerraArray(int array[], int n);

int main(){

    int array[50], qtsMaior, qtsMenor, PontoMedio = 0, seed;
    unsigned long int valorMinimo, valorMaximo;

    seed = time(NULL);
    srand(seed);

    qtsMaior = qtsMenor =  0;

    gerraArray(array, 50);

    valorMaximo = maximo(array, 50);

    valorMinimo = minimo(array, 50);

    PontoMedio = (valorMaximo + valorMinimo) / 2;

    for(int i = 0; i < 50; i++){
        if(array[i] > PontoMedio) qtsMaior += 1;
        if(array[i] < PontoMedio) qtsMenor += 1;
    }

    printf("O ponto médio é %i\n", PontoMedio);
    printf("A quantidade de valores acima do Ponto médio é: %d\n", qtsMaior);
    printf("A quantidade de valores abaixo do Ponto médio é: %d\n", qtsMenor);

    return 0;
}

void gerraArray(int array[], int n){

    for(int i = 0; i < n; i++){
        array[i] = rand();
    }
}

int maximo(int array[], int n){

    int maximo = INT_MIN;

    for(int i = 0; i < n; i++){

        if(array[i] > maximo){
            maximo = array[i];
        }
    }
    return maximo;
}

int minimo(int array[], int n){

    int minimo = INT_MAX;

    for(int i = 0; i < n; i++){
        if(array[i] < minimo){
            minimo = array[i];
        }
    }
    return minimo;
}