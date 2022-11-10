void liberaMapa();
void lerMapa();
void alocaMapa();
void imprimeMapa();
void move(char direcao);
int acabou();

struct mapa{
    char **matriz;
    int linhas;
    int colunas;
};