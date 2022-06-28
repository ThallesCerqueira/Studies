#include <stdio.h>

int main(){

    float saldo_inicial, total_cobrancas, total_creditos, limite_credito, novo_saldo = 0;
    int numero_conta = 1;

    while(numero_conta > 0){

        printf("\nEntre com o número da conta (0 para finalizar): ");
        scanf("%i", &numero_conta);

        if(numero_conta > 0){

            printf("Entre com o saldo inicial: ");
            scanf("%f", &saldo_inicial);

            printf("Entre com o total de cobranças: ");
            scanf("%f", &total_cobrancas);

            printf("Entre com o total de créditos: ");
            scanf("%f", &total_creditos);

            printf("Entre com o limite de crédito: ");
            scanf("%f", &limite_credito);

            novo_saldo = saldo_inicial + total_cobrancas - total_creditos;

            if(novo_saldo > limite_credito){

                printf("\nConta: %i\n", numero_conta);
                printf("Limite de crédito: %f\n", limite_credito);
                printf("Saldo: %f\n", novo_saldo);
                printf("Limite de cŕedito excedido.\n\n");

            }
        }
    }

    return 0;
}