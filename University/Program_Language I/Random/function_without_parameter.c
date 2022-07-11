#include <stdio.h>

float calculadora(void);
int control = 1;

int main(void) {
  
  float resultado;
  
  printf("Bem vindo à calculadora 1.0!\n");
  resultado = calculadora();

  if(control == 1) printf("O resultado da operação é: %.2f\n", resultado);
  
  return 0;
}

float calculadora(){

  float a, b, resultado;
  char operacao;
  
  printf("Infome a operação a ser feita (+, -, *, /): ");
  scanf("%c", &operacao);
  printf("Entre com o valor de a: ");
  scanf("%f", &a);
  printf("Entre com o valor de b: ");
  scanf("%f", &b);

  if(operacao == '+'){
    resultado = a + b;
  }else if(operacao == '-'){
    resultado = a - b;
  }else if(operacao == '*'){
    resultado = a * b;
  }else if(operacao == '/'){
    if(b != 0){
      resultado = a / b;
    }else{
      printf("Operação inválida, b precisa ser diferente de zero!\n");
      control = 0;
    }
  }else {
    printf("Operação inválida!\n");
    control = 0;
  }else {
    printf("Operação inválida!\n");
    control = 0;
  }  
  return resultado;
}