#include <stdio.h>

int quantosPares (int n, int array[]);

int main(void) {

  int pares[10], quantPares, n;

  //LEITURA DOS VALORES PARA O ARRAY
  printf("Qual tamanho do array? ");
  scanf("%d", &n);
  
  printf("Leitura do array de %d posições: \n\n", n);

  for(int i = 0; i < n; i++){
    printf("Posição %d: ", i);
    scanf("%d", &pares[i]);
  }

  quantPares = quantosPares(n, pares);

  printf("A quntidade de pares é: %d\n", quantPares);

  return 0;
}

int quantosPares(int n, int pares[]){

  int quantPares = 0;

  for(int i = 0; i < n; i++){
    if((pares[i] % 2) == 0){
      quantPares += 1;
    }
  }

  return quantPares;
}