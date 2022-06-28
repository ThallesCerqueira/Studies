#include <stdio.h>
#include <limits.h>

int main(){

    int entrada, maior, menor, aux , aux2, contador = 1, pares = 0;
    aux = INT_MIN;
    aux2 = INT_MAX;

    while(contador <= 10){

        printf("Digite o %iº número: ", contador);
        scanf("%i",&entrada);

        if(entrada >= aux){
            maior = entrada;
            aux = entrada;
        }

        if(entrada <= aux2){
            menor = entrada;
            aux2 = entrada;
        }

        if(entrada % 2 == 0){
            pares +=1;
        }

        contador++;
    }

    printf("O maior valor é: %i\n", maior);
    printf("O menor valor é: %i\n", menor);
    printf("A quantidade de pares é: %i\n", pares);

    return 0;
}

