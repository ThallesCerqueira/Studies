#include <stdio.h>

int main(){

    float areaCircule(float n);

    float raio, area;

    printf("Entre com o raio do circulo: ");
    scanf("%f", &raio);

    area = areaCircule(raio);

    printf("A área do circulo é: %f", area);


    return 0;
}

float areaCircule(float raio){
    float area = (raio*raio) * 3.14159;

    return area;
}