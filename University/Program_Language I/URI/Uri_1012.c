#include <stdio.h>

int main(){

    double A, B, C, ArTrRe, ArCi, ArTrap, ArQu, ArRe;

    scanf("%lf %lf %lf", &A, &B, &C);

    ArTrRe = (A * C) / 2;
    ArCi = 3.14159 * (C * C);
    ArTrap = ((A + B) * C) / 2;
    ArQu = B * B;
    ArRe = A * B;

    printf("TRIANGULO = %.3lf\n", ArTrRe);
    printf("CIRCULO = %.3lf\n", ArCi);
    printf("TRAPEZIO = %.3lf\n", ArTrap);
    printf("QUADRADO = %.3lf\n", ArQu);
    printf("RETANGULO = %.3lf\n", ArRe);

    return 0;
}