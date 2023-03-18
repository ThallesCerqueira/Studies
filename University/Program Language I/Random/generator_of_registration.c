#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int geraNumeroMatricula(void);
int verificaNumeroMatricula(int num);
void geraNumerosMatricula(int turma[], int n);

const int TRUE = 1;
const int FALSE = 0;

int main(void) {

  int matricula, turma[100];
  printf("Bem-vindo ao gerador de matrícula!\n");
  
  matricula = geraNumeroMatricula();
  geraNumerosMatricula(turma, 21);

  for(int i = 0; i < 21; i++){
    printf("%iº Matrícula: %i\n",i+1, turma[i]);
  }
  
  return 0;
}

int geraNumeroMatricula(void){

//gerar ano
//int seed = time(NULL);
int ano, semestre, identificador, matricula;
//srand(seed);
ano = 2000 + rand()%23;

//gerador de semestre
semestre = 1 + rand()%2;

//gerador de identificador

identificador = 1 + rand()%10000;

matricula = ((ano * 10 + semestre) * 10000) + identificador;

return matricula;
}

int verificaNumeroMatricula(int matricula){

  int getyear, getsemester, getrest;

  getyear = matricula / 100000;
  getsemester = (matricula / 10000) % 10;
  getrest = matricula % 10000; 

  if(getsemester < 1 || getsemester > 2){
    return FALSE;
  }
  if(getyear < 2000 || getyear > 2022){
    return FALSE; 
  }
  if(getrest < 1 || getrest > 9999){
    return FALSE;
  }

  return TRUE;
}

void geraNumerosMatricula(int turma[], int n){
  
  for(int i = 0; i < n; i++){
    
    int rep = 0;
    int aux = geraNumeroMatricula();
    
    for(int j = 0; j < i; j++){
      if(aux == turma[j]){
        rep = 1;
        break;
      }
    }

    if(rep == 1) i--;
    else turma[i] = aux;
    
  }
}