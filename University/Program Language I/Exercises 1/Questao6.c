#include <stdio.h>

int main(){

    //Opção a
    float x, y, z;

    //Opção b
    printf("Digite dois números com casas decimais:\n");
    scanf("%f", &x);
    scanf(" %f", &y);

    //Opção c
    z = x + y;
    printf("A soma entre %.2f e %.2f é: %.2f\n", x, y, z);

    //Opção d
    z = (x + y) / 2;
    printf("A média entre %.2f e %.2f é: %.2f\n", x, y, z);

    //Opção e
    z = x * y;
    printf("O produto entre %.2f e %.2f é: %.2f\n", x, y, z);

    //Opção f
    x < y ? z = x, printf("%.2f é menor do que %.2f", x, y):
     y < x ? z = y, printf("%.2f é menor do que %.2f", y, x):
        printf("Os valores são iguais");
    
    //Opção g, supondo que seja exigido o maior
    x < y ? z = y, printf("%.2f é maior do que %.2f", y, x):
     y < x ? z = x, printf("%.2f é maior do que %.2f", x, y):
        printf("Os valores são iguais");

    return 0;
}