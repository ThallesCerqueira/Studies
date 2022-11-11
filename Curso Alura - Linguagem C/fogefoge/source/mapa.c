#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "./main.h"
#include "./mapa.h"

void liberaMapa(MAPA* m){
    for(int i = 0; i < m->linhas; i++){
        free(m->matriz[i]);
    }

    free(m->matriz);
}

void lerMapa(MAPA* m){
    //Abertura do arquivo
    FILE* f;
    f = fopen("mapa.txt", "r");
    if (f == 0){
        printf("Erro na leitura do mapa!\n");
        exit(1);
    }

    //Armazenando os valores do arquivo
    fscanf(f, "%d %d", &(m->linhas), &(m->colunas));

    //Alocação do Mapa
    alocaMapa(m);

    //
    for(int i = 0; i < m->linhas; i++){
        fscanf(f, "%s", m->matriz[i]);
    }
    fclose(f);
}

void alocaMapa(MAPA* m){
    m->matriz = malloc(sizeof(char*) * m->linhas);
    for(int i = 0; i < m->linhas; i++){
        m->matriz[i] = malloc(sizeof(char) * (m->colunas+1));
    }
}

void imprimeMapa(MAPA* m){
    for(int i = 0; i < m->linhas; i++){
      printf("%s\n", m->matriz[i]);
    }
}

void  encontraMapa(MAPA* m, POSICAO* p, char c){
    for(int i = 0; i < m->linhas; i++){
        for(int j = 0; j < m->colunas; j++){
            if(m->matriz[i][j] == c){
                p->x = i;
                p->y = j;
                break;
            }
        }
    }
}

int isValida(MAPA* m, int x, int y){
    if(x >= m->linhas) return 0;
    if(y >= m->colunas) return 0;
    return 1;
}

int isVazia(MAPA* m, int x, int y){
    return m->matriz[x][y] == VAZIO;
}

void andaNoMapa(MAPA* m, int xOrigem, int yOrigem, int xDestino, int yDestino){
    char personagem;
    personagem = m->matriz[xOrigem][yOrigem];
    m->matriz[xDestino][yDestino] = personagem;
    m->matriz[xOrigem][yOrigem] = VAZIO;
}

void copiaMapa(MAPA* destino, MAPA* origem){
    destino->linhas = origem->linhas;
    destino->colunas = origem->colunas;

    alocaMapa(destino);

    for(int i = 0; i < origem->linhas; i++){
        strcpy(destino->matriz[i], origem->matriz[i]);
    }


}