//Deixei os codigos mais completos, com o intuito de provar o funcionamento dele
//e assim realizar uma conexão entre as alternativas da questão 1.

#include <stdio.h>

void troca(int *i, int *j);

//Alternativa a 
void main(){
    int x, *p, *ponteiroA, *ponteiroB, a, b;
    a = 10;
    b = 20;
    ponteiroA = &a;
    ponteiroB = &b;
    x = 100;
    p = &x;
    printf("Valor de p: %i.\n\n", *p);

    //Testando alternativa b
    troca(ponteiroA, ponteiroB);


    //Codigo da alternativa c
    char *d, *f;

    //MODO ALTERNATIVO 1
    //char vetA[] = "abacate";
    //char vetB[] = "uva";
    //d = &vetA;
    //f = &vetB;

    //MODO ALTERNATIVO 2
    //d = (char*) malloc(7 * sizeof(char));
    //f = (char*) malloc(7 * sizeof(char));

    d = "abacate";
    f = "uva";

    if(d < f){
        printf("%s vem antes de %s no dicionário.\n", d, f);
    }else{
        printf("%s vem antes de %s no dicionário.\n", f, d);
    } //Escrevi os códigos acima, somente depois que eu percebi que somente a referencia das variaveis
      // que estavam trocadas.. Pois não rodei o codigo para verificar, somente deduzi que
      // o espaço nao havia sido alocado, por tratar-se de string.

}

//Alternativa b
void troca(int *i, int *j){
   
    printf("Valor de i: %d\n", *i);
    printf("Valor de j: %d\n\n", *j);

    int *temp, tempo;
    temp = &tempo;
    *temp = *i;
    *i = *j;
    *j = *temp;

    printf("TROCA: \n\n");
    printf("Valor de i: %d\n", *i);
    printf("Valor de j: %d\n\n", *j);

}

