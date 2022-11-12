#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "./main.h"
#include "./mapa.h"

MAPA m;
POSICAO heroi;

int main(){
    
    lerMapa(&m);
    encontraMapa(&m, &heroi, HEROI);

    do{
        imprimeMapa(&m);
        char comando;
        scanf(" %c", &comando);
        move(comando);
        fantasmas();
    }while(!acabou());
    

    liberaMapa(&m);

    return 0;
}

void move(char direcao){

    if(!isDirecao(direcao)){
        return;
    }

    int proximox = heroi.x;
    int proximoy = heroi.y;

    switch (direcao){
    case ESQUERDA:
        proximoy--;
        break;
    case CIMA:
        proximox--;
        break;
    case BAIXO:
        proximox++;
        break;
    case DIRETA:
        proximoy++;
        break;
    }

    if(!isValida(&m, proximox, proximoy)) return;
    if(!isVazia(&m, proximox, proximoy)) return;

    andaNoMapa(&m, heroi.x, heroi.y, proximox, proximoy);
    heroi.x = proximox;
    heroi.y = proximoy;

}

int acabou(){
    POSICAO pos;
    int fogeFogeNoMapa = encontraMapa(&m, &pos, HEROI);
    return !fogeFogeNoMapa;
}

int isDirecao(char direcao){
    return (direcao == ESQUERDA || direcao == BAIXO || direcao == DIRETA || direcao == CIMA);
}

void fantasmas(){

    MAPA copia;

    copiaMapa(&copia, &m);

    for(int i = 0; i < copia.linhas; i++){
        for(int j = 0; j < copia.colunas; j++){
            if(copia.matriz[i][j] == FANTASMA  && isVazia(&m, i, j+1)){

                int xDestino;
                int yDestino;

                int encontrou = paraOndeFantasmaVai(i, j, &xDestino, &yDestino);

                if(encontrou){
                    if(isValida(&m, i, j+1)) andaNoMapa(&m, i, j, i, j+1);
                }
            }
        }
    }

    liberaMapa(&copia);
}

int paraOndeFantasmaVai(int xAtual, int yAtual, int* xDestino, int* yDestino){
    
    int opcoes[4][2] = {{xAtual, yAtual + 1}, {xAtual + 1, yAtual},
    {xAtual, yAtual - 1}, {xAtual -1, yAtual}};

    srand(time(0));

    for(int i = 0; i < 10; i++){
        
        int posicao = rand() % 4;

        if(isValida(&m, opcoes[posicao][0], opcoes[posicao][1]) && 
            isVazia(&m, opcoes[posicao][0], opcoes[posicao][1])){
            
            *xDestino = opcoes[posicao][0];
            *yDestino = opcoes[posicao][1];

            return 1;
        }
    }

    return 0;
}