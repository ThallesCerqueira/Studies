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

void cadastroCliente();
void menuCadastroCliente();
void incluirCliente();
void excluirCliente();
void alterarCliente();

void cadastroProduto();
void incluirProduto();
void excluirProduto();
void alterarProduto();


void venda();
void verificaCodigo();
int opcao();

int main(){

    //Variaveis
    int escolha;

    while(1){
        system("clear");
        menuPrincipal();
        escolha = opcao();
        system("clear");
        

        switch(escolha){
            case 1:
                cadastroCliente();
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
void cadastroCliente(){
    int escolha;
    system("clear");

    while(1){
        printf("\nCadastro de Clientes\n\n");
        menuCadastroCliente();
        escolha = opcao();
        system("clear");

        switch(escolha){
            case 1:
                incluirCliente();
                break;
            case 2:
                excluirCliente();
                break;
            case 3:
                alterarCliente();
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

void incluirCliente(){
    int codigoCliente;
    char nome[20];

    printf("\nIncluir cliente\n\n");
    printf("Código do cliente: ");
    scanf("%d", &codigoCliente);

    verificaCodigo();

    printf("Nome do cliente: ");
    scanf("%s", nome);
}

void excluirCliente(){
    int codigoCliente;

    printf("\nExcluir cliente\n\n");
    printf("Código do cliente: ");
    scanf("%d", &codigoCliente);
}

void alterarCliente(){
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

void verificaCodigo(){}
