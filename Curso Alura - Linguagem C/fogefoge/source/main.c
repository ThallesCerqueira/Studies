#include <stdio.h>
#include <stdlib.h>
#include "mapa.h"
#include "main.h"

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
    
    m.matriz[heroi.x][heroi.y] = '.';

    switch (direcao)
    {
    case 'a':
        m.matriz[heroi.x][heroi.y-1] = '@';
        heroi.y--;
        break;
    
    case 'w':
        m.matriz[heroi.x-1][heroi.y] = '@';
        heroi.x--;
        break;

    case 's':
        m.matriz[heroi.x+1][heroi.y] = '@';
        heroi.x++;
        break;

    case 'd':
        m.matriz[heroi.x][heroi.y+1] = '@';
        heroi.y++;
        break;
    }

}

int acabou(){
    return 0;
}