#include <stdio.h>

int main(){

    int horas_trabalhadas = 0, hora_extra;
    float valor_hora_normal, salario, valor_hora_extra;


    while(horas_trabalhadas >= 0){

        printf("Entre com o número de horas trabalhadas (-1 para finalizar): ");
        scanf("%i", &horas_trabalhadas);

        if(horas_trabalhadas >= 0){

            printf("Entre com o valor da hora normal do trabalhador: R$");
            scanf("%f", &valor_hora_normal);

            if(horas_trabalhadas > 40){

                valor_hora_extra = valor_hora_normal + (valor_hora_normal / 2);

                hora_extra = horas_trabalhadas - 40;

                salario = (40 * valor_hora_normal) + (hora_extra * valor_hora_extra);

                printf("Salário com hora extra: R$%.2f\n\n", salario);

            }else{
                
                salario = horas_trabalhadas * valor_hora_normal;

                printf("Salário: R$%.2f\n\n", salario);
            }
        }
    }

    return 0;
}