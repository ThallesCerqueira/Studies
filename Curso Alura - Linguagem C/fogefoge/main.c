#include <stdio.h>
#include <stdlib.h>

int main(){

    char mapa[5][11];

    mapa[0][0] = '|';
    mapa[4][9] = '@';

    FILE* f;

    f = fopen("mapa.txt", "r");

    if (f == 0){
        printf("Erro na leitura do mapa!\n");
        exit(1);
    }

    for(int i = 0; i < 5; i++){
        fscanf(f, "%s", mapa[i]);
    }

    for(int i = 0; i < 5; i++){
        printf("%s\n", mapa[i]);
    }

    fclose(f);

    return 0;
}