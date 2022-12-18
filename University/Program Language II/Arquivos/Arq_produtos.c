#include <stdio.h>
#include <stdlib.h>

void cria_Arq_Prod();
void consultaProdutos();
void limpaTela();

int main(){
    cria_Arq_Prod();
    consultaProdutos();
    return 0;
} 

void cria_Arq_Prod(){
    int Codigo_Produto;
    char nome_Produto[20];
    float Preco_Produto;

    FILE *fp;
    fp = fopen("Produtos.dat", "wb");
    char resp = 's';

    while(resp == 's'){
        printf("Entre com o código do produto: ");
        scanf("%d", &Codigo_Produto);

        printf("Entre com o nome do produto: ");
        scanf("%s", nome_Produto);

        printf("Entre com o valor do produto: ");
        scanf("%f", &Preco_Produto);

        fprintf(fp, "%d\n", Codigo_Produto);
        fprintf(fp, "%s\n", nome_Produto);
        fprintf(fp, "%.2f\n", Preco_Produto);

        printf("\n\nDeseja adicionar mais? <s/n> ");
        scanf(" %c", &resp);
    }
    fclose(fp);
}

void consultaProdutos(){
    int codigoProduto, codigoAchado, cont;
    char nomeProd[30];
    float precoProduto;
    cont = 0;

    FILE* fp;
    fp = fopen("Produtos.dat", "rb");

    if(fp == NULL){
        printf("Não foi possível abrir o arquivo!\n");
        exit(1);
    }

    while(1){ //lendo do arquivo até que o codigo seja difenrete de -1
        printf("\nBUSCA - Informe o código do produto: ");
        scanf("%d", &codigoProduto);
        printf("\n");

        if(codigoProduto != -1){
            do{
                limpaTela();
                fscanf(fp, "%d", &codigoAchado);
                fscanf(fp, "%s", nomeProd);
                fscanf(fp, "%f", &precoProduto);

                if(codigoAchado == codigoProduto){
                    printf("Nome do produto: %s\nPreco do produto: %.2f\n", nomeProd, precoProduto);
                }
                if(feof(fp)){
                    fseek(fp, 0, SEEK_SET);
                    cont++;
                }
                if(cont > 2){
                    printf("Código não encontrado!\n");
                    break;
                }
                
            }while(codigoAchado != codigoProduto);
            cont = 0;
            
        }else{
            break;
        }
    }
    
    fclose(fp);
}

void limpaTela(){
    printf("\e[1;1H\e[2J");
}