#include <stdio.h>

//Declaração de funções
typedef struct estoque{
    int idProduto;
    int quantidadeProduto;
    char nomeProduto[20];
} ESTOQUE;

void menuPrincipal();
void qualID();
void novoProduto(int idProduto, ESTOQUE* item);
void relatorioEstoque(int idProduto, ESTOQUE* item);
void incluirItem(int idProduto, ESTOQUE* item);
void excluirItem(int idProduto, ESTOQUE* item);
int opcao();

int main(){

    //Declarações de variaveis
    int escolha, idProduto, ID;
    ESTOQUE item[10];
    
    //Inicialização de variáveis
    idProduto = 0;

    do{
        menuPrincipal();
        escolha = opcao();

        switch(escolha){
            case 1:
                novoProduto(idProduto, item);
                idProduto++;
                break;
            case 2:
                relatorioEstoque(idProduto, item);
                break;
            case 3:
                qualID();
                ID = opcao();
                incluirItem(ID, item);
                break;
            case 4:
                qualID();
                ID = opcao();
                excluirItem(ID, item);
                break;
            default:
                return 1;
        }

    }while(escolha != 5);

    return 0;
}

//FUNÇÕES
void menuPrincipal(){
    printf("\nMENU PRINCIPAL: \n");
    printf("1 - Incluir um novo produto.\n");
    printf("2 - Mostrar relatório do estoque.\n");
    printf("3 - Incluir itens em estoque.\n");
    printf("4 - Excluir itens em estoque.\n");
    printf("5 - Sair do programa.\n");
    printf("\nEscolha: ");
}

int opcao(){
    int opcao;
    
    scanf("%d", &opcao);
        
    if(opcao > 0 && opcao < 20){
        return opcao;
    }
       
    if(opcao < 0 || opcao > 20){
      printf("Opção inválida.");
    }
    
}

void novoProduto(int idProduto, ESTOQUE* item){
    item[idProduto].idProduto = idProduto;
    item[idProduto].quantidadeProduto = 0;

    printf("\nNome do produto: ");
    scanf("%s", item[idProduto].nomeProduto);

    printf("ID do produto: %d\n", item[idProduto].idProduto);
}

void relatorioEstoque(int idProduto, ESTOQUE* item){
    for(int i = 0; i < idProduto; i++){
        printf("\nID produto: %d\n", item[i].idProduto);
        printf("Nome do produto: %s\n", item[i].nomeProduto);
        printf("Quantidade: %d\n", item[i].quantidadeProduto);
    }
}

void incluirItem(int idProduto, ESTOQUE* item){
    int quantidade = 0;

    printf("Quantos itens será adicionado a %s? ", item[idProduto].nomeProduto);
    scanf("%d", &quantidade);

    item[idProduto].quantidadeProduto += quantidade;
}

void excluirItem(int idProduto, ESTOQUE* item){
    int quantidade = 0;

    printf("Quantos itens será excluido de %s? ", item[idProduto].nomeProduto);
    scanf("%d", &quantidade);

    item[idProduto].quantidadeProduto -= quantidade;
}

void qualID(){
    printf("\nQual ID do item?");
}