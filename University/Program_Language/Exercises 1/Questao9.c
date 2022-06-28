#include <stdio.h>
#include <math.h>

int main(){

    //Declaração variáveis
    float catetooposto, catetoadjacente, hipotenusaQuadrado, hipotenusa, perimetro, area;

    //Input do cateto oposto
    printf("Informe o tamanho do Cateto Oposto:\n");
    scanf("%f", &catetooposto);

    //Input do cateto adjacente
    printf("Informe o tamanho do Cateto Adjacente:\n");
    scanf("%f", &catetoadjacente);

    //Declaração das fórmulas
    hipotenusaQuadrado = (catetoadjacente * catetoadjacente) + (catetooposto * catetooposto);
    hipotenusa = sqrt(hipotenusaQuadrado);
    perimetro = catetoadjacente + catetooposto + hipotenusa;
    area = (catetoadjacente * catetooposto) / 2;
    
    //Input dos resultados
    printf("\nO valor do quadrado da hipotenusa é: %.2f u.a\n", hipotenusaQuadrado);
    printf("O tamanho da hipotenusa é: %.2f u.a\n", hipotenusa);
    printf("O perímetro do triângulo-retangulo é: %.2f u.a\n", perimetro);
    printf("A área do triângulo-retangulo é: %.2f u.a\n", area);

    return 0;
}