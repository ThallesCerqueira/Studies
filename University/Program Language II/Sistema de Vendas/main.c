#include <stdio.h>

//VARIÁVEIS GLOBAIS
int quantidade_produtos = 0;

//Funções
void cadastrar_produto();
void excluir_produto();
void menuPrincipal();
int escolhaMenuPrincipal();

//Estruturas
typedef struct produto{
    char nome[10];
    int valor;
}PRODUTO;

PRODUTO lista[100];

int main(){

    int opcao;

    do{
        menuPrincipal();
        opcao = escolhaMenuPrincipal();

        switch (opcao){
            case 0:
                return 0;
            
            case 1:
                cadastrar_produto();
                break;
            case 2:
                excluir_produto();
                break;
            case 3:
                alterar_produto();
                break;
            case 4:
                cadastrar_cliente();
                break;
            case 5:
                excluir_cliente();
                break;
            case 6:
                alterar_cliente();
                break;
            case 7:
                fazer_venda();
                break;
            default:
                printf("Opção inválida!\n");
                continue;         
        }

    }while(opcao != 0);


    return 0;
}

int escolhaMenuPrincipal(){
    int opcao;
    scanf("%d", &opcao);
    return opcao;
}

void menuPrincipal(){
    printf("BEM-VINDO\n\n");
    printf("1. Cadastrar produto\n");
    printf("2. Exluir produto\n");
    printf("3. Alterar produto");
    printf("4. Cadastrar cliente\n");
    printf("5. Excluir cliente\n");
    printf("6. Alterar cliente\n");
    printf("7. Fazer venda\n");
    printf("0. Encerrar programa\n");
}