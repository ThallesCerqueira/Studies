#include <stdio.h>

int main(){

    int lados;

    do{
        printf("Digite a quantidade de asteriscos nos lados do triângulo: ");
        scanf("%d", &lados);

    }while(lados <= 0);

    printf("PRIMEIRO PADRÃO: \n");

    for(int linhas = 1; linhas <= lados; linhas++){
        for(int colunas = 1; colunas <= linhas; colunas++){
            printf("*");
        }
        printf("\n");
    }
    printf("\n");

    printf("SEGUNDO PADRÃO: \n");
    
    for(int linhas = 1; linhas <= lados; linhas++){
        for(int colunas = lados; colunas >= linhas; colunas--){
            printf("*");
        }
        printf("\n");
    }
    printf("\n");

    printf("TERCEIRO PADRÃO: \n");

    //Gerando primeira linha 

    for(int i = 1; i <= lados; i++){
        printf("*");
    }

    int aux = 1;

    printf("\n");

    //Próximas linhas
    
    for(int i = 1; i < lados; i++){
        for(int j = 1; j <= aux; j++){
            printf(" ");
        }
        for(int k = 1; k <= lados - aux; k++){
            printf("*");
        }
        aux++;
        printf("\n");
    }

    printf("QUARTO PADRÃO: \n");
    
    int aux2 = lados - 1;
    int aux3 = 1;

    for(int i = 1; i <= lados; i++){

        for(int j = aux2; j >= 1; j--){
            printf(" ");
        }
        for(int k = 1; k <= aux3; k++){
            printf("*");
        }
        
        printf("\n");
        aux2--;
        aux3++;
    }
    return 0;
}