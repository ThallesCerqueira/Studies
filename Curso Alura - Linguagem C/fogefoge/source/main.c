#include <stdio.h>
#include <stdlib.h>
#include "./main.h"
#include "./mapa.h"

MAPA m;
POSICAO heroi;

int main(){
    
    lerMapa(&m);
    encontraMapa(&m, &heroi, 'c');

    do{
        imprimeMapa(&m);
        char comando;
        scanf(" %c", &comando);
        move(comando);
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
    return 0;
}

int isDirecao(char direcao){
    return (direcao == ESQUERDA || direcao == BAIXO || direcao == DIRETA || direcao == CIMA);
}