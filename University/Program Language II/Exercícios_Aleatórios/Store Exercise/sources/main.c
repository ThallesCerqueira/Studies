#include <stdio.h>

//Menus
void menu_Principal(); //Funcionando
void menu_cadastro_cliente(); //Funcionando

//basics
int opcao_Menu(); //Funcionando
void cadastro_cliente(int posicaoCliente);
void incluir_cliente(int posicaoCliente);

//Declaração da estrutura
struct cadastro {
    int codigoCliente;
    nomeCliente[100];
};
struct cadastro cliente[50];

int main(){

    //Declaração das variaveis
    int opcao, posicaoCliente;

    //Inicialização de variáveis
    posicaoCliente = 0;

    while(1){
        //Chamada de funcoes
        menu_Principal();
        opcao = opcao_Menu();

        //Decidindo chamada de funcoes
        switch(opcao){
            case 1:
                cadastro_cliente(posicaoCliente);
        }
        
    }

    return 0;
}

void menu_Principal(){
    printf("MENU PRINCIPAL: \n");
    printf("\n1 - Cadastro de clientes\n");
    printf("2 - Cadastro de produtos\n");
    printf("3 - Venda\n");
    printf("4 - Sair do sistema\n");
}

int opcao_Menu(){
    int opcao;

    do{
        printf("\nDigite sua opção: ");
        scanf("%d", &opcao);

        if(opcao < 1 || opcao > 4){
            printf("\nOpção inválida!\n\n");
            menu_Principal();
        }

    }while(opcao < 1 || opcao > 4);

    return opcao;
}

void cadastro_cliente(int posicaoCliente){
    //Declaração de variáveis
    int opcao;

    //chamada de funcoes
    menu_cadastro_cliente();
    opcao = opcao_Menu();

    //Decidindo chamada de funcoes
    switch(opcao){
        case 1:
            incluir_cliente(posicaoCliente);
    }


}

void menu_cadastro_cliente(){

    printf("\nMENU - CADASTRO CLIENTE: \n");
    printf("\n1 - Incluir cliente\n");
    printf("2 - Excluir cliente\n");
    printf("3 - Alterar cliente\n");
    printf("4 - Retornar");

}

void incluir_cliente(int posicaoCliente){
    int aux;

    printf("\nINCLUIR CLIENTE \n\n");

    //Leitura e atribuição à posicao corrente na Struct, codigo
    printf("Código do cliente: ");
    scanf("%d", &aux);
    cliente[posicaoCliente].codigoCliente = aux;

    //Leitura e atribuição à posicao corrente na Struct, nome
    printf("Nome do cliente: ");
    gets(cliente[posicaoCliente].nomeCliente);
    
}
