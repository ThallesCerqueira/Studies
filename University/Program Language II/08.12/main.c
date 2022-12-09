#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct temp      // cria uma estrutura para armazenar os dados da temperatura de cada dia
{
    int mes;     // mes em que foi medida a temperatura
    int dia;     // dia em que foi medida a temperatura
    float min;   // temperatura minima no dia
    float max;   // temperatura maxima no dia
};

typedef struct temp Temp;  // criação do tipo  para armazenar a temperatura de um dia



//--------------------------------------------------------------------------------------------------------------------------------
// Função para ler as temperaturas diárias armazenadas em um arquivo (nome_arq) e colocar no vetor de temperaturas (temperatura)
//--------------------------------------------------------------------------------------------------------------------------------
int obter_temp(char nome_arq[], Temp temperatura[])
{

    char linha[50];                      // Irá armazenar uma linha lida do arquivo
    int i=0;                             // contador de linhas lidas
    FILE *fp = fopen(nome_arq, "r");     // abre o arquivo de temperaturas para leitura


    if (fp == NULL)                     // Se não conseguir ler o arquivo (se o arquivo não está no local inforomado)
    {
        perror("Não foi possível encontrar o arquivo com os dados");  // mostra uma mensagem de erro
        exit(1);                                                      // sai do programa
    }
    while(fgets(linha, sizeof(linha), fp))      // enquanto conseguir ler uma linha e armazenar na variável linha
    {
        temperatura[i].mes = atoi(strtok(linha, ","));  // armazena o mes como um inteiro , pegando as primeiras posições da linha até encontrar uma virgula
        temperatura[i].dia = atoi(strtok(NULL,  ","));  // armazena o dia como um inteiro, pegando as próximas posições da linha até encontrar uma virgula
        temperatura[i].min = atof(strtok(NULL,  ","));  // armazena a temperatura mínima do dia como um float, pegando as próximas posições da linha até encontrar uma virgula
        temperatura[i].max = atof(strtok(NULL,  ","));  // armazena a temperatura maxima do dia como um float, pegando as próximas posições da linha até encontrar uma virgula
        i++;                                            // incrementa o contadodr de linhas
    }
    fclose(fp);                                         // fecha o arquivo
    return i;                                           // retorna a quantidade de linhas lidas
}

int main()
{
    int i;                  // indice
    int qtde;               // quantidade de linhas de temperatura lidas
    Temp temperaturas[30];  // lista de temperaturas

    qtde = obter_temp("temperaturas.dat", temperaturas); // le as temperaturas de temperaturas.dat e armazena em temperaturas

    for(i=0; i< qtde; i++)                               // mostra as temperaturas que foram lidas do arquivo e estão no vetor
    {
        printf("\nMês: %d, Dia: %d, Temperatura Minima: %.1f, Temperatura Maxima: %.1f", temperaturas[i].mes, temperaturas[i].dia, temperaturas[i].min,temperaturas[i].max);
    }
}
