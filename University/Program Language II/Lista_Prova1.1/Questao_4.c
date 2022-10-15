#include <stdio.h>
#include <stdlib.h>

int funcao(char *string, char letra, int *posicoes, int *tamanho);

int main(){

    //Declaração e inicializacao das variaveis
    int *posicoes, *tamanho, tamam = 0;
    char *string = "raaba";
    char letra = 'b';
    tamanho = &tamam;

    //chamada da função 
    funcao(string, letra, posicoes, tamanho);

    //Output dos resultados
    printf("Tamanho do novo VETOR: %d\n", *tamanho);
    printf("Posições da letra '%c' na frase: ", letra);
    for(int i = 0; i < *tamanho; i++){
        printf("%i ", posicoes[i]);
    }

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
