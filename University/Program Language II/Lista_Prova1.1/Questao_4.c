#include <stdio.h>

int funcao(char *string, char letra, int *posicoes, int *tamanho);

int main(){

    //Declaração e inicializacao das variaveis
    int *posicoes;

    //posicoes = (int*) malloc(sizeof(int));
    char *string = "agor";
    char letra = 'a';
    int *tamanho;

    //chamada da função 
    funcao(string, letra, posicoes, tamanho);

    //TESTE PARA VETOR DE POSICOES
    printf("VALOR: %i\n", posicoes[0]);

    return 0;
}

int funcao(char *string, char letra, int *posicoes, int *tamanho){
    
    int contador = 0;

    while(*string != '\0'){
        //Verificando a letra selecionada
        if(*string == letra){
            contador++;
            *posicoes = contador;
        }
        string++;
    }


}
