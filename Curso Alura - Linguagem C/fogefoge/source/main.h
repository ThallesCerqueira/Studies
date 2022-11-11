#define ESQUERDA 'a'
#define DIRETA 'd'
#define CIMA 'w'
#define BAIXO 's'

void fantasmas();
void move(char direcao);
int acabou();
int isDirecao(char direcao);
int paraOndeFantasmaVai(int xAtual, int yAtual, int* xDestino, int* yDestino);

