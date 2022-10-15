#include <stdio.h>
#include <stdlib.h>

int funcao(char *string, char letra, int *posicoes, int *tamanho);

int main(){

    //Declaração e inicializacao das variaveis
    int *posicoes;

    //posicoes = (int*) malloc(sizeof(int));
    char *string = "raaba";
    char letra = 'a';
    int *tamanho, tamam = 0;
    tamanho = &tamam;


    //chamada da função 
    funcao(string, letra, posicoes, tamanho);

    //TESTE PARA VETOR DE POSICOES
    printf("Tamanho: %d\n", *tamanho);

    return 0;
}

int funcao(char *string, char letra, int *posicoes, int *tamanho){
    
    int contador = 0; // Vai representar meu valores do vetor para os indices

    while(*string != '\0'){
        
        int aux = 2;

        //Verificando a letra selecionada
        if(*string == letra){
            *posicoes = contador;
            posicoes++;
            *tamanho += 1;
        }
        contador++;
        string++;
    }
    
    return contador;
}
