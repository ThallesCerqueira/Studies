#include <stdio.h>

float calculadora(char op, float a, float b);
int control = 1;

int main(void) {
  
  float resultado, a, b;
  char op;
  
  printf("Bem vindo à calculadora 1.0!\n");
  printf("Infome a operação a ser feita (+, -, *, /): ");
  scanf("%c", &op);
  
  printf("Entre com o valor de a: ");
  scanf("%f", &a);
  printf("Entre com o valor de b: ");
  scanf("%f", &b);
  
  resultado = calculadora(op, a, b);

  if(control == 1) printf("O resultado da operação é: %.2f\n", resultado);
  
  return 0;
}

float calculadora(char op, float a, float b){

  float resultado;

  if(op == '+'){
    resultado = a + b;
  }else if(op == '-'){
    resultado = a - b;
  }else if(op == '*'){
    resultado = a * b;
  }else if(op == '/'){
    if(b != 0){
      resultado = a / b;
    }else{
      printf("Operação inválida, b precisa ser diferente de zero!\n");
      control = 0;
    }
  }else {
     printf("Operação inválida!\n");
     control = 0;
    }
  return resultado;
}