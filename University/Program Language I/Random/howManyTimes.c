#include <stdio.h>

int quantasVezesTem(int valor, int tamanho, int array[]);

int main(void) {

  int array[40], valor, tamanho, quantValor;

  printf("Qual tamanho do array? ");
  scanf("%d", &tamanho);

  printf("Qual valor você quer quantas vezes tem? ");
  scanf("%d", &valor);

  for(int i = 0; i < tamanho; i++){
    printf("%dº valor: ", i+1);
    scanf("%d", &array[i]);
  }

  quantValor = quantasVezesTem(valor, tamanho, array);

  printf("A quantidade de '%d' que há é: %d", valor, quantValor);
  
  return 0;
}

int quantasVezesTem(int valor, int tamanho, int array[]){

  int quantValor = 0;

  for(int i = 0; i < tamanho; i++){
    int aux = array[i] % valor;
    if(aux == 0) quantValor += 1;
  }

  return quantValor;
}

