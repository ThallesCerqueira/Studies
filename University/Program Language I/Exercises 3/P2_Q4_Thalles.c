#include <stdio.h>
#include <stdlib.h>

int main(){

    int lancamento, quant1, quant2, quant3, quant4, quant5, quant6, seed;
    quant1 = quant2 = quant3 = quant4 = quant5 = quant6 = 0;

    seed = time(NULL);
    srand(seed);

    for(int i = 1; i <= 100; i++){

        lancamento = 1 + rand()%6;

        printf("Cara de valor: %d\n", lancamento);

        if(lancamento == 1){
            quant1 += 1;
        }else if(lancamento == 2){
            quant2 += 1;
        }else if(lancamento == 3){
            quant3 += 1;
        }else if(lancamento == 4){
            quant4 += 1;
        }else if(lancamento == 5){
            quant5 += 1;
        }else if(lancamento == 6){
            quant6 += 1;
        }
    }

    printf("\nA quantidade de vezes que o dado caiu para cada face foi:\nFACE 1: %d\nFACE 2: %d\nFACE 3: %d\nFACE 4: %d\nFACE 5: %d\nFACE 6: %d\n", quant1, quant2, quant3, quant4, quant5, quant6);

    return 0;
}