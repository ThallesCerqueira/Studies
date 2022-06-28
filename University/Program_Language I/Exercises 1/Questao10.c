#include <stdio.h>
#include <math.h>

int main(){

    //Declaração das variáveis
    int a, b, c, delta, x1, x2, x, rFinal, x_deltazero ;

    //Input dos valores
    printf("Digite o valor de a, b, c, respectivamente:\n");
    scanf("%i", &a);
    scanf("%i", &b);
    scanf("%i", &c);

    //Fórmula Delta
    delta = (b*b) - 4 * a * c;

    //Condicional para raízes
    delta > 0 ? printf("A função tem duas raízes reais\n\n"):
        delta == 0 ? printf("A função tem uma raiz real\n"):
            printf("A função não tem raízes reais\n");


    //Fórmula das raízes
    x1 = (-b + sqrt(delta)) / (2 * a);
    x2 = (-b - sqrt(delta)) / (2 * a);

    //Estrutura condicional
    delta > 0 ? printf("Primeira Raiz = %i\nSegunda Raiz = %i\n", x1, x2):
         delta == 0 ? x_deltazero = -b / (2 * a) && printf("Raiz = %i\n", x_deltazero):
             printf("");

    //Input para x
    printf("Informe um valor para x:\n");
    scanf("%i", &x);

    //Cálculo para p(x)
    rFinal = a*(x * x) + (b * x) + c;

    //Output do resultado
    printf("P(%i) = %i\n", x, rFinal);

    return 0;
}