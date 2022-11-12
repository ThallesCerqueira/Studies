#define HEROI 'C'
#define FANTASMA 'F'
#define VAZIO '.'
#define PAREDE_VERTICAL '|'
#define PAREDE_HORIZONTAL '-'
#define PILULA 'P'

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
void copiaMapa(MAPA* destino, MAPA* origem);
void andaNoMapa(MAPA* m, int xOrigigem, int yOrigem, int xDestino, int yDestino);

int encontraMapa(MAPA* m, POSICAO* p, char c);
int isValida(MAPA* m, int x, int y);
int isVazia(MAPA* m, int x, int y);
int isParede(MAPA* m, int x, int y);
int isPersonagem(MAPA* m, char personagem, int x, int y);
int podeAndar(MAPA* m, char personagem, int x, int y);




