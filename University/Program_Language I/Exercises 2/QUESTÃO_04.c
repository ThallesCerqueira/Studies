#include <stdio.h>

int main(){

    float valor_emprestimo = 1, taxa_juros, juros;
    int periodo_do_emprestimo;

    while(valor_emprestimo > 0){

        printf("Entre com o valor do empréstimo (0 para finalizar): R$");
        scanf("%f", &valor_emprestimo);

        if(valor_emprestimo > 0){

            printf("Entre com a taxa de juro: ");
            scanf("%f", &taxa_juros);

            printf("Entre com o período do empréstimo (dias): ");
            scanf("%i", &periodo_do_emprestimo);

            juros = valor_emprestimo * taxa_juros * periodo_do_emprestimo / 365;

            printf("O valor dos juros é: %.2f\n\n", juros);

        }

    }

    return 0;
}