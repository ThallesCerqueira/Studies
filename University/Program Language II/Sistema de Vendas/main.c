#include <stdio.h>
#include <stdlib.h>
#include "headers.h"

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
                return 0;
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

        if(localizaCodigoCliente(cliente, codigoCliente, qtdCliente) < 0){
          cliente[qtdCliente].codigoCliente = codigoCliente;
          cliente[qtdCliente].totalPagar = 0;

          printf("Nome do cliente: ");
          scanf("%s", cliente[qtdCliente].nome);
          qtdCliente++;

          return qtdCliente;
        }else{
            printf("\nCódigo inválido, já existe um cliente com este código!\n");
            system("pause");
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

        posicao = localizaCodigoCliente(cliente, codigoCliente, qtdCliente);

        if(posicao == -1){
            printf("Cliente inexistente.\n");
            continue;
        }else{
            printf("Novo nome: ");
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
                return 0;
        }
    }
}
int incluirProduto(PRODUTO *produto, int qtdProduto){

    int codigoProduto;
    float valor;
    char c;

    while(1){
        limparTela();

        printf("\nIncluir produto\n\n");

        printf("Código do produto: ");
        scanf("%d", &codigoProduto);

        if(localizaCodigoProduto(produto, codigoProduto, qtdProduto) < 0){
          produto[qtdProduto].codigoProduto = codigoProduto;

          printf("Nome do produto: ");
          scanf("%s", produto[qtdProduto].nome);
          
          printf("Valor do produto: R$");
          scanf("%f", &valor);

          produto[qtdProduto].valorProduto = valor;

          qtdProduto++;
          return qtdProduto;
        }else{
            printf("\nCódigo inválido, já existe um produto com este código!\n");
            system("pause");
            continue;;
        }
    }
    return qtdProduto;
}
void excluirProduto(){

}
void alterarProduto(PRODUTO *produto, int qtdProduto){
    int posicao, codigoProduto;
    float valor;

    printf("\nAlterar Produto\n\n");
    
    while(1){
        printf("Código do produto: ");
        scanf("%d", &codigoProduto);

        posicao = localizaCodigoProduto(produto, codigoProduto, qtdProduto);

        if(posicao == -1){
            printf("Produto inexistente.\n");
            continue;
        }else{
            printf("Novo nome: ");
            scanf("%s", produto[posicao].nome);

            printf("Novo valor: R$");
            scanf("%f", &valor);
            produto[posicao].valorProduto = valor;

            return;
        }
    }
}
void menuCadastroProduto(){
    printf("\n1 - Incluir produto\n");
    printf("2 - Excluir produto\n");
    printf("3 - Alterar produto\n");
    printf("4 - Retornar\n");
    printf("\nDigite sua opção: ");
}

//FUNÇÕES VENDA
void venda(CLIENTE *cliente, int qtdCliente, PRODUTO *produto, int qtdProduto){
    int codigoCliente, codigoProduto;

    while(1){
        limparTela();

        printf("\nEfetuar Venda\n");

        printf("Código do cliente: ");
        scanf("%d", &codigoCliente);

        if(localizaCodigoCliente(cliente, codigoCliente, qtdCliente) >= 0){
            
            printf("Código do produto: ");
            scanf("%d", &codigoProduto);

            if(localizaCodigoProduto(produto, codigoProduto, qtdProduto) >= 0){

            }else{
                printf("Código de cliente inválido!\n\n");
                system("pause");
            continue;
            }

        }else{
            printf("Código de cliente inválido!\n\n");
            system("pause");
            continue;
        }
    }
}

//FUNÇÕES BÁSICAS
void limparTela(){
    printf("\e[1;1H\e[2J");
}
void menuPrincipal(){
    printf("\n1 - Cadastro de clientes.\n");
    printf("2 - Cadastro de produtos.\n");
    printf("3 - Venda.\n");
    printf("4 - Sair do sistema.\n");
    printf("\nDigite sua opção: ");
}
int localizaCodigoCliente(CLIENTE *cliente, int codigoCliente, int qtdCliente){
    for(int i = 0; i <= qtdCliente; i++){
        if(cliente[i].codigoCliente == codigoCliente){
            return i;
        }
    }
    return -1;
}
int localizaCodigoProduto(PRODUTO *produto, int codigoProduto, int qtdProduto){
    for(int i = 0; i <= qtdProduto; i++){
        if(produto[i].codigoProduto == codigoProduto){
            return i;
        }
    }
    return -1;
}
int opcao(){
    int opcao;

    scanf("%d", &opcao);

    return opcao;
}