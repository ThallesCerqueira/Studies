#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){

    int seed, resposta, entrada, contador;
    contador = 0;
    seed = time(NULL);
    srand(seed);

    resposta = 1 + rand() % 100;

    //printf("Resposta == %d\n", resposta);

    printf("Estou pensando em um número de 1 a 100, tente adivinhar qual é! \n");

    do{
        contador++;
        printf("Qual seu palpite? ");
        scanf(" %d", &entrada);

        if(entrada != resposta) printf("Errou, tente novamente!\n");

        if(entrada == resposta){
            
            printf("Excelente! Você adivinhou o número!\n\n");
            printf("Você tentou %d vezes até acertar!\n", contador);

        }else if(entrada > resposta - 25 && entrada < resposta + 25){

            printf("Muito alto. Tente novamente\n\n");

        }else{
            printf("Muito baixo. Tente novamente\n\n");
        }
        
    }while(entrada != resposta);
    

    
        


    return 0;
}
