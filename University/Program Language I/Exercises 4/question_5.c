#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

double calcPi2(int n);
double result;

int main(){

    int seed, termo;

    seed = time(NULL);
    srand(seed);
    termo = 5 + rand()%21;

    printf("Valor de n: %i\n", termo);
    calcPi2(termo);

    printf("Valor de Pi: %lf\n", result);

    return 0;
}

double calcPi2(int termo){
    
    double pi, f_zero, f_one, f_two, f_three, f_four, sub_f, mult_f;
    pi = 0;

    for(int i = 0; i < termo; i++){

        f_zero = 1.0 / (pow(16, i)); 
        f_one = 4.0 / (8 * i + 1);   
        f_two = 2.0 / (8 * i + 4);   
        f_three = 1.0 / (8 * i + 5); 
        f_four = 1.0 / (8 * i + 6);  
        sub_f = f_one - f_two - f_three - f_four; 
        mult_f = f_zero * sub_f;
        pi += mult_f;
    }

    result = pi;

    return result;
}