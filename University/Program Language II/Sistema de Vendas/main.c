#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

//ESTRUTURAS
typedef struct estruturaCliente{
    int codigoCliente;
    char nome[20];
}CLIENTE;

typedef struct estruturaProduto{
    int codigoProduto;
    int valorProduto;
    char nome[20];
}PRODUTO;

//FUNÇÕES
void menuPrincipal();                                   //FUNCIONANDO
void menuCadastroCliente();                             //FUNCIONANDO
void excluirCliente(CLIENTE *cliente);
void alterarCliente(CLIENTE *cliente, int qtdCliente);  //FUNCIONANDO
int cadastroCliente(CLIENTE *cliente, int qtdCliente);  //FUNCIONANDO
int incluirCliente(CLIENTE *cliente, int qtdCliente);   //FUNCIONANDO

int cadastroProduto(PRODUTO *produto, int qtdProduto);
int incluirProduto();
void excluirProduto();
void alterarProduto();
void menuCadastroProduto();

void venda();
void limparTela();
int verificaCodigo();
int localizaCodigo(CLIENTE *cliente, int codigoCliente, int qtdCliente); //FUNCIONANDO
int opcao(); //FUNCIONANDO

int main(){

    //Variaveis
    int escolha, qtdCliente, qtdProduto;

    //Inicialização de variavel
    qtdCliente = qtdProduto = 0;

    //Estruturas
    CLIENTE cliente[10];
    PRODUTO produto[10];

    while(1){
        limparTela();
        menuPrincipal();
        escolha = opcao();
        limparTela();

        switch(escolha){
            case 1:
                qtdCliente = cadastroCliente(cliente, qtdCliente);
                break;
            case 2:
                qtdProduto = cadastroProduto(produto, qtdProduto);
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
        limparTela();
        printf("\nCadastro de Clientes\n");

        menuCadastroCliente();
        escolha = opcao();
        limparTela();

        switch(escolha){
            case 1:
                qtdCliente = incluirCliente(cliente, qtdCliente);
                break;
            case 2:
                printf("Não implementado.");
                //excluirCliente(cliente);
                break;
            case 3:
                alterarCliente(cliente, qtdCliente);
                break;
            case 4:
                return;
        }
    }
}

void menuCadastroCliente(){
    printf("\n1 - Incluir cliente\n");
    printf("2 - Excluir cliente\n");
    printf("3 - Alterar cliente\n");
    printf("4 - Retornar\n");
    printf("\nDigite sua opção: ");
}

int incluirCliente(CLIENTE *cliente, int qtdCliente){
    int codigoCliente;

    while(1){
        limparTela();

        printf("\nIncluir cliente\n\n");

        printf("Código do cliente: ");
        scanf("%d", &codigoCliente);

        if(localizaCodigo(cliente, codigoCliente, qtdCliente) < 0){
          cliente[qtdCliente].codigoCliente = codigoCliente;

          printf("Nome do cliente: ");
          scanf("%s", cliente[qtdCliente].nome);
          qtdCliente++;

          return qtdCliente;
        }else{
            printf("Código inválido, já existe um cliente com este código!\n");
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

void alterarCliente(CLIENTE *cliente, int qtdCliente){
    int posicao, codigoCliente;
    char nome[20];

    printf("\nAlterar Cliente\n\n");
    
    while(1){
        printf("Código do cliente: ");
        scanf("%d", &codigoCliente);

        posicao = localizaCodigo(cliente, codigoCliente, qtdCliente);

        if(posicao == -1){
            printf("Cliente inexistente.\n");
            continue;
        }else{
            printf("Nome para alteração: ");
            scanf("%s", cliente[posicao].nome);
            return;
        }
    }
}

//FUNÇÕES PRODUTO
int cadastroProduto(PRODUTO *produto, int qtdProduto){
    int escolha;

    while(1){
        limparTela();
        printf("\nCadastro de Produtos\n");

        menuCadastroProduto();
        escolha = opcao();
        limparTela();

        switch(escolha){
            case 1:
                qtdProduto = incluirProduto(produto, qtdProduto);
                break;
            case 2:
                printf("Não implementado.");
                //excluirProduto(produto);
                break;
            case 3:
                alterarProduto(produto, qtdProduto);
                break;
            case 4:
                break;;
        }
    }
}
int incluirProduto(){

}
void excluirProduto(){

}
void alterarProduto(){

}
void menuCadastroProduto(){
    printf("\n1 - Incluir produto\n");
    printf("2 - Excluir produto\n");
    printf("3 - Alterar produto\n");
    printf("4 - Retornar\n");
    printf("\nDigite sua opção: ");
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

int localizaCodigo(CLIENTE *cliente, int codigoCliente, int qtdCliente){
    for(int i = 0; i <= qtdCliente; i++){
        if(cliente[i].codigoCliente == codigoCliente){
            return i;
        }
    }

    return -1;
}

void limparTela(){
    printf("\e[1;1H\e[2J");
}


//ANOTAÇÕES

/*
-- incluirCliente deve retornar a quantidade atual de clientes.


*/