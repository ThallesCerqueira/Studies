#include <stdio.h>


int main(){
    char resp;
    int dia, mes;
    float temMaxima, temMinima;
    FILE *fp;
    fp = fopen("temp.dat", "w");

    do{
        printf("Dia: ");
        scanf("%d", &dia);
        printf("Mês: ");
        scanf("%d", &mes);
        printf("Temperatura mínima: ");
        scanf("%f", &temMinima);
        printf("Temperatura máxima: ");
        scanf("%f", &temMaxima);

        fprintf(fp, "%d,%d,%.2f,%.2f\n", dia,mes,temMinima,temMaxima);

        printf("\nDeseja adicionar mais? <s/n> ");
        scanf(" %c", &resp); 
    }while(resp == 's');

    fclose(fp);

    return 0;
}