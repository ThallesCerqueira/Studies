#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    char * Vetor[4] = {'CARTAS', 'BARALHOS', 'JOGO', 'AMIGOS'};

    for(int i = 0; i < 4; i++){
        printf("%s\n", &Vetor[i]);
    }
    



    return 0;
}