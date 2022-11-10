#include <stdio.h>
#include <stdlib.h>
#include "mapa.h"
#include "main.h"

MAPA m;

int main(){
    
    lerMapa(&m);

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
    int x, y;

    //Localiza o personagem
    for(int i = 0; i < m.linhas; i++){
        for(int j = 0; j < m.colunas; j++){
            if(m.matriz[i][j] == '@'){
                x = i;
                y = j;
                break;
            }
        }
    }

    switch (direcao)
    {
    case 'a':
        m.matriz[x][y-1] = '@';
        break;
    
    case 'w':
        m.matriz[x-1][y] = '@';
        break;

    case 's':
        m.matriz[x+1][y] = '@';
        break;

    case 'd':
        m.matriz[x][y+1] = '@';
        break;
    }

    m.matriz[x][y] = '.';

}

int acabou(){
    return 0;
}