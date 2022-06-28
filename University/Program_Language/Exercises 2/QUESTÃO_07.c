#include <stdio.h>

int main(void) {

  int lado;

  printf("Digite o lado do quadrado: ");
  scanf("%i", &lado);

  if (lado >= 0 && lado <= 20){

    for(int linha = 1; linha <= lado; linha++){
      
      for(int coluna = 1; coluna <= lado; coluna++){
      
      printf("*");
      }

      printf(" \n");
    }
  }
  
  return 0;
}





//consertar, dará erro se o usuario digitar 0
