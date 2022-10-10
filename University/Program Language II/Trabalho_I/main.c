#include <stdio.h>

void mostra_menu();
int pega_opcao();
char **alocar_memoria(int linhas, int colunas);
void incluir_produto(char **estoque, int linhas, int colunas, int qtd);


int main(){

    //Declarações
    char **estoque;
    int linhas, colunas, qtd, opcao;
    linhas = 5;
    colunas = 5;
    qtd = 0;

    //Chamando funcao alocar memoria
    estoque = alocar_memoria(linhas, colunas);

    //Output's
    mostra_menu();
    opcao = pega_opcao();

    switch (opcao){
    case 1:
        //Chamando funcao incluir_produto
        incluir_produto(estoque, linhas, colunas, qtd);
        break;
    default:
        break;
    }

    return 0;
}

void mostra_menu(){
    printf("Bem-Vindo à Mercearia Tem-D-Tudo!\n");
    printf("Informe o que deseja ser feito: \n");
    printf("1 - Incluir um novo produto.\n");
    printf("2 - Mostrar relatório de estoque.\n");
    printf("3 - Incluir itens em estoque.\n");
    printf("4 - Excluir itens do estoque.\n");
    printf("5 - Sair.\n");
}

int pega_opcao(){
    int opcao;
    scanf("%i", &opcao);
    return opcao;
}
char **alocar_memoria(int linhas, int colunas){

    char **estoque;

    //alocando linhas
    estoque = (char**) malloc(linhas * sizeof(char));

    //alocando as colunas
    for(int i = 0; i < linhas; i++){
        estoque[i] = (int*) malloc(colunas * sizeof(char));
    }
}

void incluir_produto(char **estoque, int linhas, int colunas, int qtd){
    //Output
    printf("Bem vindo ao Incluir produto!\n");
    
    //Leitura dos valores
    for(int i = qtd; i < linhas; i++){
        for(int j = 0; j < colunas; j++){
            printf("Entre com %iº produto: ", i);
            scanf("%s", &estoque[i][j]);
        }
    }
}