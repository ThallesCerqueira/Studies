#include <stdio.h>
#include <stdlib.h>
#include "./main.h"
#include "./mapa.h"

MAPA m;
POSICAO heroi;

int main(){
    
    lerMapa(&m);
    encontraMapa(&m, &heroi, '@');

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
    case 'a':
        proximoy--;
        break;
    case 'w':
        proximox--;
        break;
    case 's':
        proximox++;
        break;
    case 'd':
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
    return (direcao == 'a' || direcao == 's' || direcao == 'd'|| direcao == 'w');
}