#include <stdio.h>

int main(){

    float vlm;
    int r;

    scanf("%i", &r);

    vlm = 4.0/3 * 3.14159 * (r * r * r);

    printf("VOLUME = %.3f\n", vlm);

    return 0;
}