struct mapa{
    char **matriz;
    int linhas;
    int colunas;
};

struct posicao{
    int x, y;
};

typedef struct posicao POSICAO;

typedef struct mapa MAPA;

void liberaMapa(MAPA* m);
void lerMapa(MAPA* m);
void alocaMapa(MAPA* m);
void imprimeMapa(MAPA* m);
void  encontraMapa(MAPA* m, POSICAO* p, char c);
