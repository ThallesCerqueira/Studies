#include <stdio.h>
#include <stdlib.h>

void cria_Arq_Prod();
void consultaProdutos();

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

    printf("Entre com o código do produto: ");
    scanf("%d", &Codigo_Produto);

    printf("Entre com o nome do produto: ");
    scanf("%s", nome_Produto);

    printf("Entre com o valor do produto: ");
    scanf("%f", &Preco_Produto);

    fprintf(fp, "%d\n", Codigo_Produto);
    fprintf(fp, "%s\n", nome_Produto);
    fprintf(fp, "%.2f", Preco_Produto);

    fclose(fp);
}

void consultaProdutos(){
    int codigoProduto;
    char nomeProd[30];
    float precoProduto;

    FILE* fp;
    fp = fopen("Produtos.dat", "rb");

    if(fp == NULL){
        printf("Não foi possível abrir o arquivo!\n");
        exit(1);
    }

    printf("Informe o código do produto: ");
    scanf("%d", &codigoProduto);
    printf("\n");

    if(codigoProduto != -1){
        printf("\e[1;1H\e[2J");
        fscanf(fp, "%d", &codigoProduto);
        fscanf(fp, "%s", nomeProd);
        fscanf(fp, "%f", &precoProduto);
        printf("Nome do produto: %s\nPreco do produto: %.2f\n", nomeProd, precoProduto);
    }

    fclose(fp);
}