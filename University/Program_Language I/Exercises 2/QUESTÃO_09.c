#include <stdio.h>

int main(void) {

  int valor, posi0, posi1, posi2, posi3, posi4;

  printf("Digite um inteiro palindromo: ");
  scanf("%i", &valor);

  posi4 = valor % 10;
  posi3 = (valor % 100) / 10;
  posi2 = (valor % 1000) / 100;
  posi1 = (valor % 10000) / 1000;
  posi0 = valor / 10000;

  if(posi0 == posi4 && posi1 == posi3){

    printf("Este número é um palindromo\n");
  }

  else{
    
    printf("Este número não é um palindromo\n");
  }

  return 0;
}