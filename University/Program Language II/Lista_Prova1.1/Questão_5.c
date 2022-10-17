#include <stdio.h>

void ordenar(float *ponteiroA, float *ponteiroB, float *ponteiroC, float *ponteiroD, float *vetor);

int main(){

    //Declaracao e inicializacao das variaveis
    float a, b, c, d,*ponteiroA, *ponteiroB, *ponteiroC, *ponteiroD, *vetor;
    vetor = (float*) malloc(4 * sizeof(float));
    ponteiroA = &a;
    ponteiroB = &b;
    ponteiroC = &c;
    ponteiroD = &d;

    //Entrada dos valores
    printf("Entre com o valor de A: ");
    scanf("%f", &a);

    printf("Entre com o valor de B: ");
    scanf("%f", &b);

    printf("Entre com o valor de C: ");
    scanf("%f", &c);

    printf("Entre com o valor de D: ");
    scanf("%f", &d);

    //chamada da funcao ordenar
    ordenar(ponteiroA, ponteiroB, ponteiroC, ponteiroD, vetor);

    return 0;
}

void ordenar(float *ponteiroA, float *ponteiroB, float *ponteiroC, float *ponteiroD, float *vetor){
    float aux;
    vetor[0] = *ponteiroA;
    vetor[1] = *ponteiroB;
    vetor[2] = *ponteiroC;
    vetor[3] = *ponteiroD;

    //ordenando
    for(int cont = 0; cont < 4; cont++){
        for(int i = 0; i < 4; i++){
            if(vetor[i] > vetor[i+1]){
                aux = vetor[i];
                vetor[i] = vetor[i+1];
                vetor[i+1] = aux;
            }
        }
    }

    for(int i = 0; i < 4; i++){
        printf("VETOR[%i]: %f\n", i, vetor[i]);
    }
}