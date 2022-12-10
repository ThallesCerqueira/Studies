#include <stdio.h>

//ESTRUTURAS
typedef struct estruturaCliente{
    int codigoCliente;
    char nome[20];
}CLIENTE;

typedef struct estruturaProduto{
    int codigoProduto;
    int valorProduto
}PRODUTO;

//FUNÇÕES
void menuPrincipal();

int cadastroCliente(CLIENTE *cliente, int qtdCliente);
void menuCadastroCliente();
int incluirCliente(CLIENTE *cliente, int qtdCliente);
void excluirCliente(CLIENTE *cliente);
void alterarCliente(CLIENTE *cliente);

void cadastroProduto();
void incluirProduto();
void excluirProduto();
void alterarProduto();


void venda();
int verificaCodigo();
int opcao();

int main(){

    //Variaveis
    int escolha, qtdCliente;

    //Inicialização de variavel
    qtdCliente = 0;

    //Estruturas
    CLIENTE cliente[10];

    while(1){
        system("clear");
        menuPrincipal();
        escolha = opcao();
        system("clear");
        

        switch(escolha){
            case 1:
                qtdCliente = cadastroCliente(cliente, qtdCliente);
                break;
            case 2:
                cadastroProduto();
                break;
            case 3:
                venda();
                break;
            case 4:
                return 1;
            default:
                printf("Opção Inválida");
        }

    }

    return 0;
}

void menuPrincipal(){
    printf("\n1 - Cadastro de clientes.\n");
    printf("2 - Cadastro de produtos.\n");
    printf("3 - Venda.\n");
    printf("4 - Sair do sistema.\n");
    printf("\nDigite sua opção: ");
}

int opcao(){
    int opcao;

    scanf("%d", &opcao);

    return opcao;
}

//FUNÇÕES CLIENTE
int cadastroCliente(CLIENTE *cliente, int qtdCliente){
    int escolha;

    while(1){
        system("clear");
        printf("\nCadastro de Clientes\n");
        menuCadastroCliente();
        escolha = opcao();
        system("clear");

        switch(escolha){
            case 1:
                incluirCliente(cliente, qtdCliente);
                break;
            case 2:
                excluirCliente(cliente);
                break;
            case 3:
                alterarCliente(cliente);
                break;
            case 4:
                return;
        }
    }
}

void menuCadastroCliente(){
    printf("\n1 - Incluir cliente\n");
    printf("2 - Excluir cliente\n");
    printf("3 - Alterar clinte\n");
    printf("4 - Retornar\n");
    printf("\nDigite sua opção: ");
}

int incluirCliente(CLIENTE *cliente, int qtdCliente){
    int codigoCliente;

    while(1){
        system("clear");

        printf("\nIncluir cliente\n\n");

        printf("Código do cliente: ");
        scanf("%d", &codigoCliente);

        if(!verificaCodigo()){
          cliente[qtdCliente].codigoCliente = codigoCliente;

          printf("Nome do cliente: ");
          scanf("%s", cliente[qtdCliente].nome);
          qtdCliente++;

          return qtdCliente;
        }else{
            printf("Código inválido, já existe um cliente com este código!");
            continue;
        }
    }

    return qtdCliente;
}

void excluirCliente(CLIENTE *cliente){
    int codigoCliente;

    printf("\nExcluir cliente\n\n");
    printf("Código do cliente: ");
    scanf("%d", &codigoCliente);
}

void alterarCliente(CLIENTE *cliente){
    int codigoCliente;
    char nome[20];

    printf("\nAlterar Cliente\n\n");
    printf("Código do cliente: ");
    scanf("%d", &codigoCliente);

    printf("Nome para alteração: ");
    scanf("%s", nome);
}

//FUNÇÕES PRODUTO
void cadastroProduto(){
    
}
void incluirProduto(){

}
void excluirProduto(){

}
void alterarProduto(){

}

//FUNÇÕES BÁSICAS
void venda(){
    int codigoCliente, codigoProduto;

    printf("\nEfetuar Venda\n");

    printf("Código do cliente: ");
    scanf("%d", &codigoCliente);

    printf("Código do produto: ");
    scanf("%d", &codigoProduto);

    //deve haver mensagem para produto inexistente
}

int verificaCodigo(){}


//ANOTAÇÕES

/*
-- incluirCliente deve retornar a quantidade atual de clientes.


*/