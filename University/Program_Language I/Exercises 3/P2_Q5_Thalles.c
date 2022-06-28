#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int main(){

    int respostaEst, respostaCorr, a, b, seed;
    char continua = 's';

    seed = time(NULL);
    srand(seed);

    while(continua == 's' || continua == 'S'){

        a = 1 + rand() % 9;
        b = 1 + rand() % 9;
        respostaCorr = a * b;
        
        printf("Quanto é %d vezes %d? ", a, b);

        do{
            scanf("%d", &respostaEst);

            if(respostaEst != respostaCorr){
             printf("Não. Tente novamente!\n");
            }

            if(respostaEst == respostaCorr){
             printf("Muito bem!!");
            }

        }while(respostaEst != respostaCorr);

        printf("Deseja continuar? (S/N): ");
        scanf(" %c", &continua);
    }
    

    return 0;
}