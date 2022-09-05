#include <stdio.h> #it's just a exercise that start the second semester at the university

int main(){

    qtdAlunos = 10;
    float notasTurma[qtdAlunos];
    float media = 0;


    for(int i = 0; i < qtdAlunos; i++){
        printf("Digite a nota do %iº aluno: ", i+1);
        scanf("%f", &notasTurma[i]);
        media += notasTurma[i] / 10;
    }

    printf("A média da turma foi: %.2f\n", media);



    return 0;
}