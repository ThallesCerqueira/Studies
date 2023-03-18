#include <stdio.h>

void geraImagem(int , int , int imagem[100][100]);

int main(void) {
  int imagem[100][100], linha, coluna;

  scanf("%d", &linha);
  scanf("%d", &coluna);
  
  
  geraImagem(linha, coluna, imagem);
  
  return 0;
}

void geraImagem(int linha, int coluna, int imagem[linha][coluna]){

  int valor;
  
  for(int i = 0; i < linha; i++){
    
    valor = 0;
    
    for (int j = 0; j < coluna; j++){
      imagem[i][j] = (j * 255) / coluna;
      valor++;
    }
    
  }

  for(int i = 0; i < linha; i++){
    for (int j = 0; j < coluna; j++){
      printf("%d ", imagem[i][j]);
    }
    printf("\n");
  }

  
}