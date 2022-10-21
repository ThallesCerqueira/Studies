#include <stdio.h>

//Menus
void menu_Principal(); //Funcionando
void menu_cadastro_cliente();

//basics
int opcao_Menu(); //Funcionando
void cadastro_cliente();

int main(){

    //Declaração das variaveis
    int opcao;

    while(1){
        //Chamada de funcoes
        menu_Principal();
        opcao = opcao_Menu();

        //Decidindo chamada de funcoes
        switch(opcao){
            case 1:
                cadastro_cliente();
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

void cadastro_cliente(){
    menu_cadastro_cliente();
    opcao_Menu();
}

void menu_cadastro_cliente(){

    printf("\nMENU - CADASTRO CLIENTE: \n");
    printf("\n1 - Incluir cliente\n");
    printf("2 - Excluir cliente\n");
    printf("3 - Alterar cliente\n");
    printf("4 - Retornar");

}