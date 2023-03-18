#include <stdio.h>

void triangle_1(int n);
void triangle_2(int n);
void triangle_3(int n);
void triangle_4(int n);
void typetriangle(int tipo, int n);

int main(){

    int lados, tipo;

    do{
        printf("Digite o número do tipo de triângulo: ");
        scanf("%d", &tipo);

    }while(tipo <= 0 || tipo > 4);

    do{
        printf("Digite a quantidade de asteriscos nos lados do triângulo: ");
        scanf("%d", &lados);

    }while(lados <= 0);

    typetriangle(tipo, lados);

    return 0;
}

triangle_1(int lados){
    printf("PRIMEIRO PADRÃO: \n");

    for(int linhas = 1; linhas <= lados; linhas++){
        for(int colunas = 1; colunas <= linhas; colunas++){
            printf("*");
        }
        printf("\n");
    }
    printf("\n");
}

triangle_2(int lados){
    printf("SEGUNDO PADRÃO: \n");
    
    for(int linhas = 1; linhas <= lados; linhas++){
        for(int colunas = lados; colunas >= linhas; colunas--){
            printf("*");
        }
        printf("\n");
    }
    printf("\n");
}

triangle_3(int lados){
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
}

triangle_4(int lados){
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
}

typetriangle(int tipo, int lados){
    if(tipo == 1){

        triangle_1(lados);
    }else if(tipo == 2){

        triangle_2(lados);
    }else if(tipo == 3){

        triangle_3(lados);
    }else{
        triangle_4(lados);
    }

}