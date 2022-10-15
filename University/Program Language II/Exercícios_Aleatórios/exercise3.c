#include <stdio.h>

int main(){

    int matriz[3][3];
    int somaLinha[3];
    int somaColuna[3];
    int somaPrincipal = 0;
    int somaSecundaria = 0;
    int somatorio;
   
    //entrada da matriz
    for(int i = 0; i < 3; i++){
        somatorio = 0;
        for(int j = 0; j < 3; j++){
            //Entrada elementos
            printf("\nEntre com o elemento A%i%i: ", i+1, j+1);
            scanf("%i", &matriz[i][j]);
            //soma das linhas
            somatorio+= matriz[i][j];
        }
        somaLinha[i] = somatorio;
    }

    //Somatorio das colunas
    for(int j = 0; j < 3; j++){
        somatorio = 0;
        for(int i = 0; i < 3; i++){
            somatorio+= matriz[i][j];
        }
        somaColuna[j] = somatorio;
    }

    //print da matriz
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            printf("%i", matriz[i][j]);
        }
        printf("\n");
    }


    ///Somatorio da diagonal secundaria
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(i == j){
                somaPrincipal = somaPrincipal + matriz[i][j];
            }
            if((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)){
                somaSecundaria += matriz[i][j];
            }
        }
    }

    if(somaLinha[0] == somaLinha[1] == somaLinha[2]){
        if(somaColuna[0] == somaColuna [1] == somaColuna[2]){
            if(somaPrincipal == somaSecundaria){
                printf("\nQuadrado mágico!");
            }
        }
    }else{
        printf("Quadrado não mágico!\n");
    }

    return 0;
}