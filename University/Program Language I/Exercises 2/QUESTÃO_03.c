#include <stdio.h>

int main(){

    float pg_semana = 200, venda_porcento = 0.09, venda_bruta = 0, salario;

    while (venda_bruta >= 0){

        printf("Entre com a venda (-1 para finalizar): R$");
        scanf("%f", &venda_bruta);

        if(venda_bruta >= 0){
            
            salario = pg_semana + (venda_porcento * venda_bruta);

            printf("Salário: R$%.2f\n\n", salario);
        }
    }

    return 0;
}

