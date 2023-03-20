#include <stdio.h> 
#include <stdlib.h> 
#include <string.h> 
#define CSVSIZE 16400

typedef struct
{
    int rankID;             
    char *name;
    char *Platform;
    int year;
    char *genre;
    char *publisher;
    float NA_Sales;
    float EU_Sales;
    float JP_Sales;
    float Other_Sales;
    float Global_Sales;
} TBook;

int main(void)
{
    TBook *acervo;
    FILE *fp;
    char str[900];
    int i = 0;
    
    acervo = (TBook*) malloc(CSVSIZE*sizeof(TBook));

    fp = fopen("../../Data/dataSetEquipe2.csv", "r");
    
    if(fp == NULL) 
    {
        printf("Arquivo não pode ser aberto\n");
        exit(1);
    }

    // pegando o cabeçalho
    char *ok;
    ok = fgets(str, 900, fp); // pega a string do arquivo

    if(!ok)
    {
        printf("Erro lendo o cabeçalho do CSV!!!", str);
        return 1;
    }

    i = 0;
    char sep[] = ",";
    
    while(!feof(fp) && i < CSVSIZE) // enquanto nâo chegar no final do arquivo ou no tamanho do array
    {   
        ok = fgets(str, 900, fp); // pega a string do arquivo 
        if(ok)
        {
            char *campo;

            //int rankID
            campo = strtok(str, sep);  // pega a string até a primeira ','
            acervo[i].rankID = atoi(campo); // converte em int
            
            //char NOME
            campo = strtok(NULL, sep);
            int pos = 0;
            while(campo[pos] != 15 && pos < strlen(campo))
                pos++;
            campo[pos] = '\0';
            acervo[i].name = (char*) malloc(strlen(campo)+1);
            strcpy(acervo[i].name, campo);

            //PLATAFORMA
            campo = strtok(NULL, sep);
            acervo[i].Platform = (char*) malloc(strlen(campo)+1);
            strcpy(acervo[i].Platform, campo);

            //ANO
            campo = strtok(NULL, sep); 
            acervo[i].year = atoi(campo); // converte em int

            //GENERO
            campo = strtok(NULL, sep);
            acervo[i].genre = (char*) malloc(strlen(campo)+1);
            strcpy(acervo[i].genre, campo);

            //PUBLISHER
            campo = strtok(NULL, sep);
            pos = 0;
            while(campo[pos] != 10 && pos < strlen(campo))
                pos++;
            campo[pos] = '\0';
            acervo[i].publisher = (char*) malloc(strlen(campo)+1);
            strcpy(acervo[i].publisher, campo);

            //NA SALES
            campo = strtok(NULL, sep);
            acervo[i].NA_Sales = atof(campo); // converte em float

            //EU SALES
            campo = strtok(NULL, sep);
            acervo[i].EU_Sales = atof(campo); // converte em float

            //JP SALES
            campo = strtok(NULL, sep);
            acervo[i].JP_Sales = atof(campo); // converte em float

            //Other sales - Other continents
            campo = strtok(NULL, sep);
            acervo[i].Other_Sales = atof(campo); // converte em float

            //global sales
            campo = strtok(NULL, sep);
            acervo[i].Global_Sales = atof(campo); // converte em float
            
            i++;
        }
    }

    int id;
    do
    {
        printf("\n\nEntre com índice de um item do acervo (-1 para sair) (%d < RANK < %d): ", 0, i);
        scanf("%d", &id);

        if(id == -1) exit(1);

        printf("\nRANK: %d\n", acervo[id].rankID);
        printf("NAME: %s\n", acervo[id].name);
        printf("PLATAFORMA: %s\n", acervo[id].Platform);
        printf("ANO: %d\n", acervo[id].year);
        printf("GENERO: %s\n", acervo[id].genre);
        printf("PUBLISHER: %s\n", acervo[id].publisher);
        printf("NA SALES: %.2f\n", acervo[id].NA_Sales);
        printf("EU SALES: %.2f\n", acervo[id].EU_Sales);
        printf("JP SALES: %.2f\n", acervo[id].JP_Sales);
        printf("OTHER SALES: %.2f\n", acervo[id].Other_Sales);
        printf("GLOBAL SALES: %.2f\n", acervo[id].Global_Sales);

    } while (id != -1);

    for(int j = 0; j < i; j++)
    {
        free(acervo[j].name);
        free(acervo[j].Platform);
        free(acervo[j].genre);
        free(acervo[j].publisher);
        
    }
    free(acervo);
    int err = fclose(fp);
    if (err)
    {
        printf("Arquivo incorretamente fechado!!\n");
    }
    return 0;
}