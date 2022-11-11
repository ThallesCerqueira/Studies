#define HEROI 'C'
#define FANTASMA 'F'
#define VAZIO '.'
#define PAREDE_VERTICAL '|'
#define PAREDE_HORIZONTAL '-'

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
int encontraMapa(MAPA* m, POSICAO* p, char c);
void copiaMapa(MAPA* destino, MAPA* origem);
void andaNoMapa(MAPA* m, int xOrigigem, int yOrigem, int xDestino, int yDestino);
int isValida(MAPA* m, int x, int y);
int isVazia(MAPA* m, int x, int y);
int podeAndar(MAPA* m, int x, int y);



