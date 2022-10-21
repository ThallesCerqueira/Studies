#include <stdio.h>

//Menus
void menu_Principal();

//basics
int opcao_Menu();

int main(){

    //Declaração das variaveis
    int opcao;

    while(1){
        menu_Principal();
        opcao = opcao_Menu();
        
    }




    return 0;
}

void menu_Principal(){
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