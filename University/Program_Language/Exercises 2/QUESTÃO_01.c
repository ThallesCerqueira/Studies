#include <stdio.h>

int main(){

    float litros_consum = 0, litros_total = 0, km_percorrido, km_total = 0 , rendimento_individual, rendimento_total;
    
    while (litros_consum >= 0){

        printf("Entre com os litros consumidos (-1 para finalizar): ");
        scanf("%f", &litros_consum);

        if(litros_consum >= 0){

            printf("Entre com os quilômetros percorridos: ");
            scanf("%f", &km_percorrido);

            km_total += km_percorrido;
            litros_total += litros_consum;
            rendimento_individual = km_percorrido / litros_consum;

            printf("A taxa km/litro para esse tanque foi: %f\n\n", rendimento_individual);

        }

    }

    rendimento_total = km_total / litros_total;
    
    if(rendimento_total > 0){
        printf("\nA taxa total de Km/Litro foi: %f\n", rendimento_total);
    }

    return 0;
}