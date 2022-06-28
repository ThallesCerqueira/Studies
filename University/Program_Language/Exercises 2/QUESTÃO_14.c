#include <stdio.h>

int main(){

    /*Este programa só vai até o fatorial de 12 pois o valor maximo para um int é 2.147.483.647
     se colocarmos 13 como entrada vai exceder tal valor
    */

    long int entrada, valor_entrada, fatorial = 1;

    do{

        printf("Digite um número inteiro positivo: ");
        scanf("%d", &entrada);

        if(entrada < 0){

            printf("O valor deve ser maior ou igual a zero!\n\n");
        }

    }while(entrada < 0);

    if(entrada >= 1){

        valor_entrada = entrada; // guardar valor da entrada

        while(entrada >= 1){
            
            fatorial *= entrada;
            entrada--; 
        }

        printf("O fatorial de %d é %d\n", valor_entrada, fatorial);

    }else{
        
        printf("O fatorial de %d é 1\n\n", entrada);
    }

    return 0;
}